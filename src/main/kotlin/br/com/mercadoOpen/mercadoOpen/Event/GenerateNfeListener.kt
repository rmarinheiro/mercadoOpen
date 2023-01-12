package br.com.mercadoOpen.mercadoOpen.Event

import br.com.mercadoOpen.mercadoOpen.Service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class GenerateNfeListener(
    private val purchaseService:PurchaseService
) {

    @EventListener
    @Async
    fun listen(purchaseEvent: PurchaseEvent){
        print("Gerando NFe")
        val nfe = UUID.randomUUID().toString()
        var purchaseModel = purchaseEvent.purchaseModel.copy(nfe=nfe)
        purchaseService.update(purchaseModel)
    }
}