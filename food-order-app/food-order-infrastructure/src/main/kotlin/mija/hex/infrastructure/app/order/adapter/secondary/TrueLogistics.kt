package mija.hex.infrastructure.app.order.adapter.secondary

import mija.hex.domain.order.infrastructure.port.secondary.Logistics
import mija.hex.infrastructure.CommandBus
import mija.hex.infrastructure.command.DeliverOrderCommand
import mija.hex.infrastructure.command.PrepareDishCommand

internal class TrueLogistics(private val commandBus: CommandBus) : Logistics {

    override fun prepareOrder(orderId: Int) {
        commandBus.fire(PrepareDishCommand(orderId))
    }

    override fun deliver(orderId: Int) {
        commandBus.fire(DeliverOrderCommand(orderId))
    }
}