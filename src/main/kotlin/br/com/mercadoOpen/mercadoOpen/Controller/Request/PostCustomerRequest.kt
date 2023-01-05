package br.com.mercadoOpen.mercadoOpen.Controller.Request

import br.com.mercadoOpen.mercadoOpen.Validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest (
    @field:NotEmpty(message =  "Informe um nome valido")
    var name: String,

    @field:Email(message = "Email deve ser invalido")
    @EmailAvailable
    var email: String
)