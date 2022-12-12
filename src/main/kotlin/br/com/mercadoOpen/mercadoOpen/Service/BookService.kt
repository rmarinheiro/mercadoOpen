package br.com.mercadoOpen.mercadoOpen.Service

import br.com.mercadoOpen.mercadoOpen.Model.BookModel
import br.com.mercadoOpen.mercadoOpen.Repository.BookRepository
import br.com.mercadoOpen.mercadoOpen.enuns.BookEnum
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository : BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(): List<BookModel> {
        return bookRepository.findAll().toList();

    }

    fun findActive(): List<BookModel> {
        return bookRepository.findByStatus(BookEnum.ATIVO)
    }

    fun findById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    fun delete(id: Int) {
        val book = findById(id)
         book.status = BookEnum.CANCELADO
        update(book)

    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }


}
