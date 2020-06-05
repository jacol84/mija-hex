package mija.hex.domain.order

import mija.hex.domain.order.port.primary.CronService
import mija.hex.domain.order.port.primary.FoodOrderService
import mija.hex.domain.order.port.secondary.Logistics
import mija.hex.domain.order.port.secondary.OrderStore

class OrderFacade(private val orderStore: OrderStore, private val logistics: Logistics) {


    val foodOrderService: FoodOrderService
    val cronService: CronService

    init {
        foodOrderService = FoodOrderServiceImpl(orderStore)
        cronService = CronServiceImpl(orderStore, logistics)
    }

}