package mija.hex.domain.order

import mija.hex.domain.order.port.primary.FoodOrderService
import mija.hex.domain.order.port.secondary.OrderStore

class OrderFacade(orderStore: OrderStore) {

    private val service: FoodOrderService

    init {
        service = FoodOrderServiceImpl(orderStore)
    }

    fun getFoodOrderService(): FoodOrderService {
        return service;
    }
}