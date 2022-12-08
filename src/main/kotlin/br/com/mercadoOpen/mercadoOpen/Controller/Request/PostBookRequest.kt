package br.com.mercadoOpen.mercadoOpen.Controller.Request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookRequest(
    var nome : String,

    var  price : BigDecimal,

    @JsonAlias("customer_id")
    var customerId : Int

)


