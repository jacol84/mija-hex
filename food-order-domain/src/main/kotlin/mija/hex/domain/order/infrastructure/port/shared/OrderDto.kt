package mija.hex.domain.order.infrastructure.port.shared

data class OrderDto(val orderId: Int, val disName: String, val address: String, val state: OrderState)

