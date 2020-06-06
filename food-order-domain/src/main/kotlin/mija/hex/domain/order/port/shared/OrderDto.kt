package mija.hex.domain.order.port.shared

data class OrderDto(val orderId: Int, val disName: String, val address: String, val state: OrderState)

