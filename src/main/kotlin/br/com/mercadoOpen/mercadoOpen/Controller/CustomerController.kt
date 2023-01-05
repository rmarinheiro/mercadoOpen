package br.com.mercadoOpen.mercadoOpen.Controller

import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PutCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Extensions.toCustomer
import br.com.mercadoOpen.mercadoOpen.Extensions.toResponse
import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import br.com.mercadoOpen.mercadoOpen.Response.CustomerResponse
import br.com.mercadoOpen.mercadoOpen.Service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("customer")
class CustomerController(
      val customerService : CustomerService
) {



    @GetMapping
    fun getAll(@RequestParam name:String?): List<CustomerResponse> {
            return customerService.getAll(name).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerResponse {
            return customerService.getById(id).toResponse()

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int,@RequestBody @Valid customer: PutCustomerRequest) {
        var customerSaved= customerService.getById(id)
        customerService.update(customer.toCustomer(customerSaved))

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid customer:PostCustomerRequest) {
        customerService.create(customer.toCustomer())
    }


}