package mija.hex.domain.order.infrastructure

import mija.hex.domain.order.infrastructure.port.FoodOrderQueryServiceImpl
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import mija.hex.domain.order.infrastructure.port.secondary.Logistics
import mija.hex.domain.order.infrastructure.port.secondary.OrderStore

class OrderFacade(private val orderStore: OrderStore, private val logistics: Logistics) {

    val foodOrderCommandService: FoodOrderCommandService
    val foodOrderQueryService: FoodOrderQueryService

    init {
        foodOrderCommandService = FoodOrderCommandServiceImpl(orderStore, logistics)
        foodOrderQueryService = FoodOrderQueryServiceImpl(orderStore)
    }

}