package br.com.mercadoOpen.mercadoOpen.Repository

import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<CustomerModel,Int> {

    fun findByNameContaining(name:String):List<CustomerModel>
     fun existsByEmail(value: String):Boolean


}