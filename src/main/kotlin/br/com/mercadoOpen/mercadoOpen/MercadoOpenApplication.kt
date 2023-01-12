package br.com.mercadoOpen.mercadoOpen

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class MercadoOpenApplication

fun main(args: Array<String>) {
	runApplication<MercadoOpenApplication>(*args)
}
