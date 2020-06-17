package app.delivery.adpater.primary

import mija.hex.domain.delivery.DeliveryFacade
import mija.hex.domain.delivery.port.primary.DeliveryCommandService
import org.springframework.stereotype.Service

@Service
internal class DeliveryCommandAppService(deliveryFacade: DeliveryFacade) : DeliveryCommandService by deliveryFacade.deliveryCommandService