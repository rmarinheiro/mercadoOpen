package br.com.mercadoOpen.mercadoOpen.Controller

import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostBookRequest
import br.com.mercadoOpen.mercadoOpen.Extensions.toBookModel
import br.com.mercadoOpen.mercadoOpen.Service.BookService
import br.com.mercadoOpen.mercadoOpen.Service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book")
class BookController(
    val custmerService : CustomerService,
    val bookService: BookService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest){
        val customer = custmerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }
}