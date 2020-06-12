package mija.hex.domain.restaurant.infrastructure.adapter.secondary

import mija.hex.domain.restaurant.port.secondary.OrderNotification
import mija.hex.infrastructure.command.MarkOrderAsRedyToDeliveryCommand
import org.springframework.context.ApplicationEventPublisher

class OrderNotificationAdapter(private val applicationEventPublisher: ApplicationEventPublisher) : OrderNotification {
    override fun orderReady(orderId: Int) = applicationEventPublisher.publishEvent(MarkOrderAsRedyToDeliveryCommand(orderId))
}