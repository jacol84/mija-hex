package mija.hex.domain.order

import mija.hex.domain.order.port.shared.OrderState

data class Order(val orderId: Int, val disName: String, val state: OrderState)
// TODO public only getter