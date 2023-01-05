package br.com.mercadoOpen.mercadoOpen.Controller.Request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PostBookRequest(
    @field:NotEmpty(message = "Nome não pode ser vazio")
    var nome : String,

    @field:NotNull(message = "Preço não pode ser vazio")
    var  price : BigDecimal,

    @JsonAlias("customer_id")
    var customerId : Int

)


