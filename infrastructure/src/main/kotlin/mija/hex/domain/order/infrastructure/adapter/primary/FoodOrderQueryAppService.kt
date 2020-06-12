package mija.hex.domain.order.infrastructure.adapter.primary

import mija.hex.domain.order.infrastructure.OrderFacade
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import org.springframework.stereotype.Service

@Service
class FoodOrderQueryAppService(private val orderFacade: OrderFacade) : FoodOrderQueryService by orderFacade.foodOrderQueryService