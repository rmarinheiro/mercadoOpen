package br.com.mercadoOpen.mercadoOpen.exception

import br.com.mercadoOpen.mercadoOpen.Response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleException(ex:NotFoundException,request:WebRequest):ResponseEntity<ErrorResponse>{
       val error =  ErrorResponse(
            httpCode =  HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            errors =  null,
        )

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}