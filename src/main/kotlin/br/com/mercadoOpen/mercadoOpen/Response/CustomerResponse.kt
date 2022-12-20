package br.com.mercadoOpen.mercadoOpen.Response

import br.com.mercadoOpen.mercadoOpen.enuns.CustomerStatus

data class CustomerResponse (
    var id: Int? = null,


    var name:String,


    var email: String,


    var status : CustomerStatus
)
