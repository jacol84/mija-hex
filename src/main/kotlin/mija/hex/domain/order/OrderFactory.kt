package mija.hex.domain.order

import mija.hex.domain.order.port.shared.OrderState
import java.util.concurrent.atomic.AtomicInteger

class OrderFactory {

    object Singleton {
        var Sequence = AtomicInteger()
    }

    fun createOrder(disName: String): Order {
        return Order(Singleton.Sequ ence.getAndIncrement(), disName, OrderState.NEW)
    }
}