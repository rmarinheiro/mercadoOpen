package br.com.mercadoOpen.mercadoOpen.Model

import br.com.mercadoOpen.mercadoOpen.enuns.BookEnum
import java.math.BigDecimal
import javax.persistence.*


@Entity
@Table(name = "Book")
data class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var nome: String,

    @Column
    var price: BigDecimal,


    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null

) {
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookEnum? = null
        set(value) {
            if (field == BookEnum.CANCELADO || field == BookEnum.DELETADO) {
                throw Exception("Não é possível alterar um livro com status ${field}")
            }
            field = value
        }

    constructor(
        id: Int? = null,
        nome: String,
        price: BigDecimal,
        customer: CustomerModel? = null,
        status: BookEnum?
    ) : this(id, nome, price, customer) {
        this.status = status
    }
}