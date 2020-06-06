package mija.hex.domain.order.port

import mija.hex.domain.order.port.primary.FoodOrderQueryService
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderDto

class FoodOrderQueryServiceImpl(private val orderStore: OrderStore) : FoodOrderQueryService {
    override fun getOrderDetails(orderId: Int): OrderDto? = orderStore.load(orderId)
}