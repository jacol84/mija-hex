package mija.hex.domain.order

import mija.hex.domain.order.port.shared.OrderDto
import mija.hex.domain.order.port.shared.OrderState
import java.util.concurrent.atomic.AtomicInteger

data class Order internal constructor(val orderId: Int, val disName: String, val state: OrderState)

object OrderFactory {

    private val SEQUENCE = AtomicInteger()


    fun createOrder(disName: String): Order {
        return Order(SEQUENCE.incrementAndGet(), disName, OrderState.NEW)
    }

    fun from(orderDto: OrderDto): Order = orderDto.toOrder()

    fun toOrderDto(order: Order) = order.toOrderDto()

}

private fun OrderDto.toOrder() = Order(orderId, disName, state)

private fun Order.toOrderDto() = OrderDto(orderId, disName, state)
