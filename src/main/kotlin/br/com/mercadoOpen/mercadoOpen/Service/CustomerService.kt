package br.com.mercadoOpen.mercadoOpen.Service

import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import br.com.mercadoOpen.mercadoOpen.Repository.CustomerRepository
import br.com.mercadoOpen.mercadoOpen.enuns.CustomerStatus
import br.com.mercadoOpen.mercadoOpen.enuns.Errors
import br.com.mercadoOpen.mercadoOpen.exception.NotFoundException
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable


@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService : BookService
) {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(name)
        }
        return customerRepository.findAll().toList()

    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow{NotFoundException(Errors.ML201.message.format(id),Errors.ML101.code)}

    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception("Customer não encontrado")
        }
        customerRepository.save(customer)
    }

    fun delete(@PathVariable id: Int) {
        val customer = getById(id)
        bookService.deleteByCustomer(customer)
        customer.status =  CustomerStatus.INATIVO
        customerRepository.save(customer)
        //customerRepository.delete(customer)
    }

}
