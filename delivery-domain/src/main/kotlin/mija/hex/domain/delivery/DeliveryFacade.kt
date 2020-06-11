package mija.hex.domain.delivery

import mija.hex.domain.delivery.port.primary.DeliveryCommandService
import mija.hex.domain.delivery.port.secondary.OrderDetails
import mija.hex.domain.delivery.port.secondary.OrderNotification

class DeliveryFacade(orderDetails: OrderDetails, orderNotification: OrderNotification) {
    val deliveryCommandService: DeliveryCommandService = DeliveryCommandServiceImpl(orderDetails, orderNotification)
}