package br.com.mercadoOpen.mercadoOpen.Service

import br.com.mercadoOpen.mercadoOpen.Model.BookModel
import br.com.mercadoOpen.mercadoOpen.Repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository : BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

}
