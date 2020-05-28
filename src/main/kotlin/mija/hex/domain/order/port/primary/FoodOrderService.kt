package mija.hex.domain.order.port.primary

import mija.hex.domain.order.port.shared.OrderState

interface FoodOrderService {
    fun createOrder(disName: String): Int
    fun getOrderState(orderId: Int): OrderState?
}