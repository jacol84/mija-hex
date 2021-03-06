package mija.hex.domain.order.infrastructure

import mija.hex.domain.order.infrastructure.port.shared.OrderDto
import mija.hex.domain.order.infrastructure.port.shared.OrderState
import java.util.concurrent.atomic.AtomicInteger

data class Order internal constructor(val orderId: Int, val disName: String, val address: String, var state: OrderState) {
    fun changeState(newOrderState: OrderState) {
        state = when {
            state == OrderState.NEW && newOrderState == OrderState.SENT_TO_RESTAURANT -> newOrderState
            state == OrderState.SENT_TO_RESTAURANT && newOrderState == OrderState.READY_TO_DELIVERY -> newOrderState
            state == OrderState.READY_TO_DELIVERY && newOrderState == OrderState.DELIVERED -> newOrderState
            else -> throw IllegalStateException("Cannot change status from [$state] to [$newOrderState]")
        }
    }
}

object OrderFactory {

    private val SEQUENCE = AtomicInteger()


    fun createOrder(disName: String, address: String): Order {
        return Order(SEQUENCE.incrementAndGet(), disName, address, OrderState.NEW)
    }

    fun from(orderDto: OrderDto): Order = orderDto.toOrder()

    fun toOrderDto(order: Order) = order.toOrderDto()

}

private fun OrderDto.toOrder() = Order(orderId, disName, address, state)

private fun Order.toOrderDto() = OrderDto(orderId, disName, address, state)
