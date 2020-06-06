package mija.hex.infrastructure.domain.order.service.spring

import mija.hex.domain.order.OrderFacade
import mija.hex.domain.order.port.primary.FoodOrderCommandService
import org.springframework.stereotype.Service

@Service
class FoodOrderCommandAppService(private val orderFacade: OrderFacade) : FoodOrderCommandService by orderFacade.foodOrderCommandService