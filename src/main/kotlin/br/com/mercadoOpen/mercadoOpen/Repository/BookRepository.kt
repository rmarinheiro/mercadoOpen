package br.com.mercadoOpen.mercadoOpen.Repository

import br.com.mercadoOpen.mercadoOpen.Model.BookModel
import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import br.com.mercadoOpen.mercadoOpen.enuns.BookEnum
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel,Int> {
     fun findByStatus(ativo: BookEnum): List<BookModel>


}