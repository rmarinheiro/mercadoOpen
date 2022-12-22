package br.com.mercadoOpen.mercadoOpen.exception

class NotFoundException( override  val message:String, val errorCode:String) : Exception() {
}