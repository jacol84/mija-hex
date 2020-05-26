package mija.hex.domain.order

import mija.hex.domain.order.port.shared.OrderState

data class Order(var orderId: Int, var disName: String, var status: OrderState) 