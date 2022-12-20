package br.com.mercadoOpen.mercadoOpen.Response

import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel
import br.com.mercadoOpen.mercadoOpen.enuns.BookEnum
import java.math.BigDecimal

data class BookResponse (

    var id: Int? = null,


    var nome: String,


    var price: BigDecimal,

    var customer: CustomerModel? = null,

    var status : BookEnum? = null
)