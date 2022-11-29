package br.com.mercadoOpen.mercadoOpen.Service

import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import br.com.mercadoOpen.mercadoOpen.Repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable


@Service
class CustomerService(
    val customerRepository: CustomerRepository
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

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.findById(id).get()

    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception("Customer não encontrado")
        }
        customerRepository.save(customer)
    }

    fun delete(@PathVariable id: Int) {
        if (!customerRepository.existsById(id)) {
            throw Exception("Customer não encontrado")
        }
        customerRepository.deleteById(id)
    }

}
