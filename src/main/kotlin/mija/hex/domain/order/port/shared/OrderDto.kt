package mija.hex.domain.order.port.shared

data class OrderDto(val orderId: Int, val dishName: String, val state: OrderState)

