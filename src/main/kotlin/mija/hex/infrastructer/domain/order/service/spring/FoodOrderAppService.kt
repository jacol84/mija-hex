package mija.hex.infrastructer.domain.order.service.spring

import mija.hex.domain.order.OrderFacade
import mija.hex.domain.order.port.primary.FoodOrderService
import org.springframework.stereotype.Service

@Service
class FoodOrderAppService(private val orderFacade: OrderFacade) : FoodOrderService by orderFacade.foodOrderService