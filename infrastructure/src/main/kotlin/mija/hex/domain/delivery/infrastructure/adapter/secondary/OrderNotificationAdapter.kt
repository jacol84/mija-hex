package mija.hex.domain.delivery.infrastructure.adapter.secondary

import mija.hex.domain.delivery.port.secondary.OrderNotification
import mija.hex.infrastructure.command.MarkOrderAsDeliveredCommand
import org.springframework.context.ApplicationEventPublisher

class OrderNotificationAdapter(private val applicationEventPublisher: ApplicationEventPublisher) : OrderNotification {
    override fun orderReady(orderId: Int) {
        applicationEventPublisher.publishEvent(MarkOrderAsDeliveredCommand(orderId))
    }
}