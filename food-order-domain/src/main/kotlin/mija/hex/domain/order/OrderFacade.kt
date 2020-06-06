package mija.hex.domain.order

import mija.hex.domain.order.port.FoodOrderQueryServiceImpl
import mija.hex.domain.order.port.primary.FoodOrderCommandService
import mija.hex.domain.order.port.primary.FoodOrderQueryService
import mija.hex.domain.order.port.secondary.Logistics
import mija.hex.domain.order.port.secondary.OrderStore

class OrderFacade(private val orderStore: OrderStore, private val logistics: Logistics) {

    val foodOrderCommandService: FoodOrderCommandService
    val foodOrderQueryService: FoodOrderQueryService

    init {
        foodOrderCommandService = FoodOrderCommandServiceImpl(orderStore, logistics)
        foodOrderQueryService = FoodOrderQueryServiceImpl(orderStore)
    }

}