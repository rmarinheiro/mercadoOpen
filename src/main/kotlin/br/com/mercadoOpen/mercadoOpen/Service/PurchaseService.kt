package br.com.mercadoOpen.mercadoOpen.Service

import br.com.mercadoOpen.mercadoOpen.Event.PurchaseEvent
import br.com.mercadoOpen.mercadoOpen.Model.PurchaseModel
import br.com.mercadoOpen.mercadoOpen.Repository.PurchaseRepository
import br.com.mercadoOpen.mercadoOpen.enuns.BookEnum
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private  val purchaseRepository: PurchaseRepository,
    private val applicationEventPublish:ApplicationEventPublisher,
    private val bookService: BookService
) {

    fun create(purchaseModel:PurchaseModel){
        for(books in purchaseModel.books){
            books.id?.let {
                 val book = bookService.findById(it)
                if(book.status == BookEnum.VENDIDO){
                    throw Exception("Livro ja vendido")
                }
            }
        }
        purchaseRepository.save(purchaseModel)
        println("Disparando evento de compra")
        applicationEventPublish.publishEvent(PurchaseEvent(this,purchaseModel))
        print("Finalizando evento de compra")
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)

    }

}
