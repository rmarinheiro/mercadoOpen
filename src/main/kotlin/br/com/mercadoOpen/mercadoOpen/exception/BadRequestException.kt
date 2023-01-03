package br.com.mercadoOpen.mercadoOpen.exception

class BadRequestException(override  val message:String, val errorCode:String) : Exception() {
}