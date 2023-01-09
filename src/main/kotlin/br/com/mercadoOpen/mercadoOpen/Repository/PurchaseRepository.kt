package br.com.mercadoOpen.mercadoOpen.Repository

import br.com.mercadoOpen.mercadoOpen.Model.PurchaseModel
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository:CrudRepository<PurchaseModel,Int> {

}
