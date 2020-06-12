package mija.hex.domain.order.infrastructure.adapter.secondary

import mija.hex.domain.delivery.port.primary.DeliveryCommandService
import mija.hex.domain.order.infrastructure.port.secondary.Logistics
import mija.hex.domain.restaurant.port.primary.CookCommandService

class TrueLogistics(private val cookCommandService: CookCommandService, private val deliveryCommandService: DeliveryCommandService) : Logistics {
    override fun prepareOrder(orderId: Int) {
        cookCommandService.prepareOrder(orderId)
    }

    override fun deliver(orderId: Int) {
        deliveryCommandService.deliveryOrder(orderId)
    }
}