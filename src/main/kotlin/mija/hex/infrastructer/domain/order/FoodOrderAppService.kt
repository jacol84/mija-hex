package mija.hex.infrastructer.domain.order

import mija.hex.domain.order.OrderFacade
import mija.hex.domain.order.port.primary.FoodOrderService
import org.springframework.stereotype.Service

@Service
class FoodOrderAppService(private val orderFacade: OrderFacade) : FoodOrderService by orderFacade.getFoodOrderService()