package mija.hex.infrastructure.app.restaurant.adapter.secondary

import mija.hex.domain.restaurant.port.secondary.OrderNotification
import mija.hex.infrastructure.CommandBus
import mija.hex.infrastructure.command.MarkOrderAsReadyToDeliveryCommand

internal class OrderNotificationAdapter(private val commandBus: CommandBus) : OrderNotification {
    override fun orderReady(orderId: Int) = commandBus.fire(MarkOrderAsReadyToDeliveryCommand(orderId))
}