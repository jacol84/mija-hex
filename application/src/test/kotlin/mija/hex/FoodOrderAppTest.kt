package mija.hex


import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import mija.hex.domain.order.infrastructure.port.shared.OrderState
import org.junit.Assert.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest(classes = [FoodOrderApp::class])
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