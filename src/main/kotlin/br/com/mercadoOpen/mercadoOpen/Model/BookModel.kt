package br.com.mercadoOpen.mercadoOpen.Model

import br.com.mercadoOpen.mercadoOpen.enuns.BookEnum
import java.math.BigDecimal
import javax.persistence.*


@Entity
@Table(name = "book")
data class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var nome:String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status : BookEnum,

    @ManyToOne
    @JoinColumn(name="customer_id")
    var  customer:CustomerModel? = null


)