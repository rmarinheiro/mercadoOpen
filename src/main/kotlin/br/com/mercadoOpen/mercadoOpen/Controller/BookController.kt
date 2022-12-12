package br.com.mercadoOpen.mercadoOpen.Controller

import br.com.mercadoOpen.mercadoOpen.Controller.Request.BookRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostBookRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PutBookRequest
import br.com.mercadoOpen.mercadoOpen.Extensions.toBookModel
import br.com.mercadoOpen.mercadoOpen.Model.BookModel
import br.com.mercadoOpen.mercadoOpen.Service.BookService
import br.com.mercadoOpen.mercadoOpen.Service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
    fun create(@RequestBody request: PostBookRequest) {
        val customer = custmerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookModel>{
        return bookService.findAll()
    }

    @GetMapping("/active")
    fun findActvie() : List<BookModel> =
        bookService.findActive()

    @GetMapping("/{id}")
    fun findById(@PathVariable id :Int): BookModel{
        return bookService.findById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int){
        return bookService.delete(id)

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id :Int, @RequestBody book: PutBookRequest){
            val bookSave= bookService.findById(id)
            bookService.update(book.toBookModel(bookSave))
    }

}