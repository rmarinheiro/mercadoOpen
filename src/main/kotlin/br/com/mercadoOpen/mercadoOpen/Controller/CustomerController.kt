package br.com.mercadoOpen.mercadoOpen.Controller

import br.com.mercadoOpen.mercadoOpen.Controller.Request.PostCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Controller.Request.PutCustomerRequest
import br.com.mercadoOpen.mercadoOpen.Extensions.toCustomer
import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import br.com.mercadoOpen.mercadoOpen.Service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(
      val customerService : CustomerService
) {



    @GetMapping
    fun getAll(@RequestParam name:String?): List<CustomerModel> {
            return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
            return customerService.getCustomer(id)

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String,@RequestBody customer: PutCustomerRequest) {
        customerService.update(customer.toCustomer(id))

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        customerService.delete(id)

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer:PostCustomerRequest) {
        customerService.create(customer.toCustomer())
    }


}