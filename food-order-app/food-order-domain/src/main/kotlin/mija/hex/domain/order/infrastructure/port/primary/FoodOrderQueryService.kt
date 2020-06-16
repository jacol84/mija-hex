package mija.hex.domain.order.infrastructure.port.primary

import mija.hex.domain.order.infrastructure.port.shared.OrderDto

interface FoodOrderQueryService {
    fun getOrderDetails(orderId: Int): OrderDto?
}