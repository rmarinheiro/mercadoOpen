package br.com.mercadoOpen.mercadoOpen.Event

import br.com.mercadoOpen.mercadoOpen.Model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent (
     sources:Any,
    val purchase:PurchaseModel
) : ApplicationEvent(sources)