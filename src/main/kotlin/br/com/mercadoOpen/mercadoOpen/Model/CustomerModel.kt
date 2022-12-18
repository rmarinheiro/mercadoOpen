package br.com.mercadoOpen.mercadoOpen.Model

import br.com.mercadoOpen.mercadoOpen.enuns.CustomerStatus
import javax.persistence.*


@Entity
@Table(name = "Customer")
data class CustomerModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name:String,

    @Column
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status : CustomerStatus

)