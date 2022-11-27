package br.com.mercadoOpen.mercadoOpen.Extensions

import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PutCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel

fun PostCustomerRequest.toCustomer():CustomerModel{
        return CustomerModel(name =this.name,email=this.email)
}

fun PutCustomerRequest.toCustomer(id:String):CustomerModel{

        return CustomerModel(id = id ,name =this.name,email=this.email)
}
