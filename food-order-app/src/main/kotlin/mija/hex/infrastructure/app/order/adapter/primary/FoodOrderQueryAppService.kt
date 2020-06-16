package mija.hex.infrastructure.app.order.adapter.primary

import mija.hex.domain.order.infrastructure.Order
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import org.springframework.stereotype.Service

@Service
internal class FoodOrderQueryAppService(private val orderFacade: OrderFacade) : FoodOrderQueryService by orderFacade.foodOrderQueryService