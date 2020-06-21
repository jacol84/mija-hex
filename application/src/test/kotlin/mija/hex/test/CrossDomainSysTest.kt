package mija.hex.test

import mija.hex.FoodOrderApp
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import mija.hex.domain.order.infrastructure.port.shared.OrderState
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest(classes = [FoodOrderApp::class], webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CrossDomainSysTest {
    @Autowired
    private lateinit var foodOrderCommandService: FoodOrderCommandService

    @Autowired
    private lateinit var foodOrderQueryService: FoodOrderQueryService

    @Test
    fun basicScenario() {
        //given
        //when
        val orderId = foodOrderCommandService.createOrder("Pizza", "Wall Street")
        //then
        assertEquals(OrderState.NEW, foodOrderQueryService.getOrderDetails(orderId)?.state)
        //when
        foodOrderCommandService.makeOrder()
        //then
        assertEquals(OrderState.READY_TO_DELIVERY, foodOrderQueryService.getOrderDetails(orderId)?.state)
        //when
        foodOrderCommandService.makeOrder()
        //then
        assertEquals(OrderState.DELIVERED, foodOrderQueryService.getOrderDetails(orderId)?.state)
    }
}