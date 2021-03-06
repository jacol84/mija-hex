package mija.hex.domain.order.infrastructure.port

import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import mija.hex.domain.order.infrastructure.port.secondary.OrderStore
import mija.hex.domain.order.infrastructure.port.shared.OrderDto

class FoodOrderQueryServiceImpl(private val orderStore: OrderStore) : FoodOrderQueryService {
    override fun getOrderDetails(orderId: Int): OrderDto? = orderStore.load(orderId)
}