package br.com.mercadoOpen.mercadoOpen.Model

import br.com.mercadoOpen.mercadoOpen.enuns.BookEnum
import br.com.mercadoOpen.mercadoOpen.enuns.Errors
import br.com.mercadoOpen.mercadoOpen.exception.BadRequestException
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
                throw BadRequestException(Errors.ML201.message.format(field), Errors.ML201.code)
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