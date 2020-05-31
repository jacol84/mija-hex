package mija.hex


import mija.hex.domain.order.port.primary.FoodOrderService
import mija.hex.domain.order.port.shared.OrderState
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
    lateinit var foodOrderService: FoodOrderService


    @Test
    internal fun applicationContextTest() {
        assertNotNull(applicationContext)
    }

    @Test
    internal fun createOrderUsingApplicationServices() {
        assertNotNull(foodOrderService)
        val orderId = foodOrderService.createOrder("Pizza")
        val orderState = foodOrderService.getOrderState(orderId)
        assertEquals(OrderState.NEW, orderState)
    }
}