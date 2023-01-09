package br.com.mercadoOpen.mercadoOpen.Service

import br.com.mercadoOpen.mercadoOpen.Event.PurchaseEvent
import br.com.mercadoOpen.mercadoOpen.Model.PurchaseModel
import br.com.mercadoOpen.mercadoOpen.Repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private  val purchaseRepository: PurchaseRepository,
    private val applicationEventPublish:ApplicationEventPublisher
) {

    fun create(purchaseModel:PurchaseModel){
        purchaseRepository.save(purchaseModel)
        applicationEventPublish.publishEvent(PurchaseEvent(this,purchaseModel))
    }

}
