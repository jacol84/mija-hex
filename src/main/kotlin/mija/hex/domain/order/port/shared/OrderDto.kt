package mija.hex.domain.order.port.shared

data class OrderDto(var orderId: Int, var dishName: String, var state: OrderState)

