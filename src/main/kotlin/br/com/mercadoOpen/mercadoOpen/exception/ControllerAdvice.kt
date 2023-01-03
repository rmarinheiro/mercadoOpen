package br.com.mercadoOpen.mercadoOpen.exception

import br.com.mercadoOpen.mercadoOpen.Response.ErrorResponse
import br.com.mercadoOpen.mercadoOpen.Response.FieldErrorResponse
import br.com.mercadoOpen.mercadoOpen.enuns.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotException(ex:NotFoundException,request:WebRequest):ResponseEntity<ErrorResponse>{
       val error =  ErrorResponse(
            httpCode =  HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            errors =  null,
        )

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex:BadRequestException,request:WebRequest):ResponseEntity<ErrorResponse>{
        val error =  ErrorResponse(
            httpCode =  HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            errors =  null,
        )

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentException(ex: MethodArgumentNotValidException,request: WebRequest):ResponseEntity<ErrorResponse>{
        val error =  ErrorResponse(
            httpCode =  HttpStatus.UNPROCESSABLE_ENTITY.value(),
            Errors.ML001.message,
            Errors.ML001.code,
            ex.bindingResult.fieldErrors.map{ FieldErrorResponse(it.defaultMessage ?:"invalid" , it.field )}
        )

        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}