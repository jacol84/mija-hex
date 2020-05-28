package mija.hex.domain.order

import mija.hex.domain.order.port.shared.OrderDto

internal interface OrderMapper {
    fun toOrderDto(order: Order): OrderDto
    fun toOrder(orderDto: OrderDto): Order
}
