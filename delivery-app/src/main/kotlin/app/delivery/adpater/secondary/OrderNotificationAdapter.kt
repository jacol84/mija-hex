package app.delivery.adpater.secondary

import mija.hex.domain.delivery.port.secondary.OrderNotification
import mija.hex.infrastructure.CommandBus
import mija.hex.infrastructure.command.MarkOrderAsDeliveredCommand

internal class OrderNotificationAdapter(private val commandBus: CommandBus) : OrderNotification {
    override fun orderReady(orderId: Int) = commandBus.fire(MarkOrderAsDeliveredCommand(orderId))
}