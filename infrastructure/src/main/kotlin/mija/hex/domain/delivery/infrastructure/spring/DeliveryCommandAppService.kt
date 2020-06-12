package mija.hex.domain.delivery.infrastructure.spring

import mija.hex.domain.delivery.DeliveryFacade
import mija.hex.domain.delivery.port.primary.DeliveryCommandService
import org.springframework.stereotype.Service

@Service
class DeliveryCommandAppService(deliveryFacade: DeliveryFacade) : DeliveryCommandService by deliveryFacade.deliveryCommandService