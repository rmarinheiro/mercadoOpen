package br.com.mercadoOpen.mercadoOpen.Event

import br.com.mercadoOpen.mercadoOpen.Service.BookService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class UpdateBookListener(
    private val bookService: BookService
) {

    @EventListener
    @Async
    fun listen(purchaseEvent: PurchaseEvent){
        println("Atualizando status do livro")
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}