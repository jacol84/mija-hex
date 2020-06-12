package mija.hex.domain.order.infrastructure.adapter.secondary

import mija.hex.domain.order.infrastructure.port.secondary.Logistics
import mija.hex.infrastructure.command.DeliverOrderCommand
import mija.hex.infrastructure.command.PrepareDishCommand
import org.springframework.context.ApplicationEventPublisher

class TrueLogistics(private val eventPublisher: ApplicationEventPublisher) : Logistics {

    override fun prepareOrder(orderId: Int) {
        eventPublisher.publishEvent(PrepareDishCommand(orderId))
    }

    override fun deliver(orderId: Int) {
        eventPublisher.publishEvent(DeliverOrderCommand(orderId))
    }
}