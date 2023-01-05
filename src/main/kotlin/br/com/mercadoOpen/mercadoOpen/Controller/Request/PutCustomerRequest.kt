package br.com.mercadoOpen.mercadoOpen.Controller.Request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCustomerRequest (
    @field:NotEmpty(message = "Nome não pode ser nulo")
    var name: String,

    @field:Email(message = "Email precisa ser valido")
    var email: String,

)