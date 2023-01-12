package br.com.mercadoOpen.mercadoOpen.Controller.Mapper

import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostPurchaseRequest
import br.com.mercadoOpen.mercadoOpen.Model.PurchaseModel
import br.com.mercadoOpen.mercadoOpen.Service.BookService
import br.com.mercadoOpen.mercadoOpen.Service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper (
    private val bookService:BookService,
    private val customerService:CustomerService

){
    fun toModel(request:PostPurchaseRequest):PurchaseModel{
      val customer =  customerService.getById(request.customerId)
      val books = bookService.findAllById(request.bookids)
        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }
}