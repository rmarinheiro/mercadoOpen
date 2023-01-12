package br.com.mercadoOpen.mercadoOpen.Service

import br.com.mercadoOpen.mercadoOpen.Model.BookModel
import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import br.com.mercadoOpen.mercadoOpen.Repository.BookRepository
import br.com.mercadoOpen.mercadoOpen.enuns.BookEnum
import br.com.mercadoOpen.mercadoOpen.enuns.Errors
import br.com.mercadoOpen.mercadoOpen.exception.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository : BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable);

    }

    fun findActive(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookEnum.ATIVO,pageable)
    }

    fun findById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow{NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code)}
    }

    fun delete(id: Int) {
        val book = findById(id)
         book.status = BookEnum.CANCELADO
        update(book)

    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)
        for ( book in books){
            book.status = BookEnum.DELETADO
        }
        bookRepository.saveAll(books)
    }

    fun findAllById(bookids: Set<Int>): List<BookModel> {
        return bookRepository.findAllById(bookids).toList()
    }

    fun purchase(books: MutableList<BookModel>) {
        books.map {
            it.status = BookEnum.VENDIDO
        }
        bookRepository.saveAll(books)
    }


}
