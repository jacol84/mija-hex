package mija.hex.infrastructure.app.order.adapter.primary

import mija.hex.domain.order.infrastructure.OrderFacade
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
import org.springframework.stereotype.Service

@Service
internal class FoodOrderCommandAppService(private val orderFacade: OrderFacade) : FoodOrderCommandService by orderFacade.foodOrderCommandService