package br.com.mercadoOpen.mercadoOpen.Model

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
    var email: String

)