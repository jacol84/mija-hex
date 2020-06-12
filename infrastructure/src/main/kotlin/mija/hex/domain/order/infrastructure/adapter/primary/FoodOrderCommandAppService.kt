package mija.hex.domain.order.infrastructure.adapter.primary

import mija.hex.domain.order.infrastructure.OrderFacade
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
import org.springframework.stereotype.Service

@Service
class FoodOrderCommandAppService(private val orderFacade: OrderFacade) : FoodOrderCommandService by orderFacade.foodOrderCommandService