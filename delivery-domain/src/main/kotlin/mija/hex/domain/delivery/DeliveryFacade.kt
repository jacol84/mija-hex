package mija.hex.domain.delivery

import mija.hex.domain.delivery.port.primary.DeliveryService
import mija.hex.domain.delivery.port.secondary.OrderDetails
import mija.hex.domain.delivery.port.secondary.OrderNotification

class DeliveryFacade(private val orderDetails: OrderDetails, private val orderNotification: OrderNotification) {
    val deliveryServiceImpl: DeliveryService = DeliveryServiceImpl(orderDetails, orderNotification)
}