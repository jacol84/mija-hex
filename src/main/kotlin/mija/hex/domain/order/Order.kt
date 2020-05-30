package mija.hex.domain.order

import mija.hex.domain.order.port.shared.OrderDto
import mija.hex.domain.order.port.shared.OrderState
import java.util.concurrent.atomic.AtomicInteger

data class Order internal constructor(val orderId: Int, val disName: String, val state: OrderState)
// TODO public only getter

object OrderFactory {

    private val SEQUENCE = AtomicInteger()
    private val orderMapper: OrderMapper = OrderMapperImpl()

    fun createOrder(disName: String): Order {
        return Order(SEQUENCE.incrementAndGet(), disName, OrderState.NEW)
    }

    fun from(orderDto: OrderDto): Order {
        return orderMapper.toOrder(orderDto)
    }

    fun toOrderDto(order: Order): OrderDto {
        return orderMapper.toOrderDto(order)
    }
}