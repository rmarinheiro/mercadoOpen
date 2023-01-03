package br.com.mercadoOpen.mercadoOpen.enuns

enum class Errors(val code:String, val message:String) {
    ML001("ML-001","Invalid Request"),
    ML101("ML-101", message = "Book [%s] not exists"),
    ML102("ML-102", message = "Cannot update book with status cancelado [%s]"),
    ML201("ML-201", message = "Custom [%s] not exists")

}