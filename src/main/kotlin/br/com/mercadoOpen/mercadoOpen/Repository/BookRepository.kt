package br.com.mercadoOpen.mercadoOpen.Repository

import br.com.mercadoOpen.mercadoOpen.Model.BookModel
import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import br.com.mercadoOpen.mercadoOpen.enuns.BookEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository: JpaRepository<BookModel,Int> {
     fun findByStatus(ativo: BookEnum, pageable: Pageable): Page<BookModel>
     fun findByCustomer(customer: CustomerModel) : List<BookModel>

     //fun findAll(pageable:Pageable) : Page<BookModel>


}