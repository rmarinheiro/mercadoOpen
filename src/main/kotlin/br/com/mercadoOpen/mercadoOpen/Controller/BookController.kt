package br.com.mercadoOpen.mercadoOpen.Controller

import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostBookRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PutBookRequest
import br.com.mercadoOpen.mercadoOpen.Extensions.toBookModel
import br.com.mercadoOpen.mercadoOpen.Extensions.toResponse
import br.com.mercadoOpen.mercadoOpen.Response.BookResponse
import br.com.mercadoOpen.mercadoOpen.Service.BookService
import br.com.mercadoOpen.mercadoOpen.Service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


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
    fun findAll(@PageableDefault(page = 0, size = 10)pageable:Pageable): Page<BookResponse>{
        return bookService.findAll(pageable).map { it.toResponse() }
    }

    @GetMapping("/active")
    fun findActvie(@PageableDefault(page = 0, size = 10)pageable:Pageable) : Page<BookResponse> =
        bookService.findActive(pageable).map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id :Int): BookResponse{
        return bookService.findById(id).toResponse()
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