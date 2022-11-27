package br.com.mercadoOpen.mercadoOpen.Controller.Request

import br.com.mercadoOpen.mercadoOpen.Model.CustomerModel

data class PostCustomerRequest (
    var name: String,

    var email: String
){

}