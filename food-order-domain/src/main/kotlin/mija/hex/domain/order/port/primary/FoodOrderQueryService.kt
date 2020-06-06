package mija.hex.domain.order.port.primary

import mija.hex.domain.order.port.shared.OrderDto

interface FoodOrderQueryService {
    fun getOrderDetails(orderId: Int): OrderDto?
}