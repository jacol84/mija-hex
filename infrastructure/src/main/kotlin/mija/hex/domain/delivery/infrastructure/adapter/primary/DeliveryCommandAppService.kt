package mija.hex.domain.delivery.infrastructure.adapter.primary

import mija.hex.domain.delivery.DeliveryFacade
import mija.hex.domain.delivery.port.primary.DeliveryCommandService
import mija.hex.infrastructure.command.DeliverOrderCommand
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
internal class DeliveryCommandAppService(deliveryFacade: DeliveryFacade) : DeliveryCommandService by deliveryFacade.deliveryCommandService {
    @EventListener
    fun handlerPrepareOrder(deliverOrderCommand: DeliverOrderCommand) = deliveryOrder(deliverOrderCommand.orderId)
}