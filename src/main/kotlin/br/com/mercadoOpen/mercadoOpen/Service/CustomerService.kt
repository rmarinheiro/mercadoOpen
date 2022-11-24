package br.com.mercadoOpen.mercadoOpen.Service

import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PutCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable


@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name:String?): List<CustomerModel> {
        name?.let {
            return  customers.filter { it.name.contains(name,true) }
        }
        return customers

    }

    fun create(customer: PostCustomerRequest){
        val id = if(customers.isEmpty()){
            1
        }else{
            customers.last().id.toInt() +1
        }.toString()



        customers.add(CustomerModel(id,customer.name,customer.email))
        println(customers)
    }

    fun getCustomer(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()

    }

    fun update(id: String, customer: PutCustomerRequest) {
        customers.filter { it.id == id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }

    }

    fun delete(@PathVariable id: String) {
        customers.removeIf {it.id == id }

    }
}