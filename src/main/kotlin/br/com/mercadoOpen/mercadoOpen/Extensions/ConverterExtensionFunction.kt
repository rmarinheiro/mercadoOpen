package br.com.mercadoOpen.mercadoOpen.Extensions

import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostBookRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PutBookRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PutCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Model.BookModel
import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import br.com.mercadoOpen.mercadoOpen.Response.BookResponse
import br.com.mercadoOpen.mercadoOpen.Response.CustomerResponse
import br.com.mercadoOpen.mercadoOpen.enuns.BookEnum
import br.com.mercadoOpen.mercadoOpen.enuns.CustomerStatus
import ch.qos.logback.core.net.SyslogOutputStream

fun PostCustomerRequest.toCustomer():CustomerModel{
        return CustomerModel(name =this.name,email=this.email, status = CustomerStatus.ATIVO)
}

fun PutCustomerRequest.toCustomer(previousValue:CustomerModel):CustomerModel{
        return CustomerModel(id = previousValue.id ,name =this.name,email=this.email, status = previousValue.status)
}

fun PostBookRequest.toBookModel(customer:CustomerModel):BookModel{
        return BookModel(
                nome =this.nome,
                price = this.price,
                status =  BookEnum.ATIVO,
                customer =  customer
        )
}

fun PutBookRequest.toBookModel(previousValue:BookModel):BookModel{
        return BookModel(
                id =previousValue.id,
                nome = this.nome?:previousValue.nome,
                price = this.price?:previousValue.price,
                status  = previousValue.status,
                customer =  previousValue.customer
        )
}

fun CustomerModel.toResponse(): CustomerResponse {
        return CustomerResponse(
                id = this.id,
                name = this.name,
                email = this.email,
                status = this.status
        )
}

fun BookModel.toResponse(): BookResponse{
        return  BookResponse(
                id = this.id,
                nome = this.nome,
                price = this.price,
                customer = this.customer,
                status = this.status
        )
}


