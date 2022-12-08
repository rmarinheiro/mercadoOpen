package br.com.mercadoOpen.mercadoOpen.Extensions

import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostBookRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PutCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Model.BookModel
import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import br.com.mercadoOpen.mercadoOpen.enuns.BookEnum

fun PostCustomerRequest.toCustomer():CustomerModel{
        return CustomerModel(name =this.name,email=this.email)
}

fun PutCustomerRequest.toCustomer(id:Int):CustomerModel{

        return CustomerModel(id = id ,name =this.name,email=this.email)
}

fun PostBookRequest.toBookModel(customer:CustomerModel):BookModel{
        return BookModel(
                nome =this.nome,
                price = this.price,
                status =  BookEnum.ATIVO,
                customer =  customer
        )
}


