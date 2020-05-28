package mija.hex.domain.order

import mija.hex.domain.order.port.shared.OrderDto

class OrderMapperImpl : OrderMapper {

    override fun toOrderDto(order: Order): OrderDto {
        val (orderId, disName, status) = order
        return OrderDto(orderId, disName, status)
    }

    override fun toOrder(orderDto: OrderDto): Order {
        val (orderId, disName, status) = orderDto
        return Order(orderId, disName, status)
    }

}
