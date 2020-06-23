package mija.hex

import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import mija.hex.domain.order.infrastructure.port.shared.OrderState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import kotlin.test.Test

@SpringBootTest(classes = [FoodOrderApp::class], webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class FoodOrderAppTest {

    @Autowired
    lateinit var applicationContext: ApplicationContext

    @Autowired
    lateinit var foodOrderCommandService: FoodOrderCommandService

    @Autowired
    lateinit var foodOrderQueryService: FoodOrderQueryService


    @Test
    internal fun applicationContextTest() {
        assertNotNull(applicationContext)
    }

    @Test
    internal fun createOrderUsingApplicationServices() {
        assertNotNull(foodOrderCommandService)
        val orderId = foodOrderCommandService.createOrder("Pizza", "ul. Balonowa")
        val orderDto = foodOrderQueryService.getOrderDetails(orderId)
        assertEquals(OrderState.NEW, orderDto?.state)
    }
}