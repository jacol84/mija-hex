package mija.hex.infrastructure.domain.order.service.spring

import mija.hex.domain.order.OrderFacade
import mija.hex.domain.order.port.primary.FoodOrderCommandService
import mija.hex.domain.order.port.primary.FoodOrderQueryService
import org.springframework.stereotype.Service

@Service
class FoodOrderQueryAppService(private val orderFacade: OrderFacade) : FoodOrderQueryService by orderFacade.foodOrderQueryService