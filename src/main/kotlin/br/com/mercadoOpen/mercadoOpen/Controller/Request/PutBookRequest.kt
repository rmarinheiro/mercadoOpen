package br.com.mercadoOpen.mercadoOpen.Controller.Request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PutBookRequest(
    var nome : String?,

    var  price : BigDecimal?,

)


