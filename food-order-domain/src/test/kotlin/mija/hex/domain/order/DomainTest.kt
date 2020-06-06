package mija.hex.domain.order

import mija.hex.domain.order.port.primary.FoodOrderCommandService
import kotlin.test.Test

class DomainTest {
    @Test
    fun `simple domain test`() {
        val orderFacade = OrderFacade(createOrderStoreForTest(), createEmptyLogistic())
        val foodOrderCommandService: FoodOrderCommandService = orderFacade.foodOrderCommandService
        val orderId: Int = foodOrderCommandService.createOrder("Burger", "ul. Balonowa")
        println("OrderId: $orderId")
        val orderDto = orderFacade.foodOrderQueryService.getOrderDetails(orderId)
        println("OrderState: ${orderDto?.state}")

    }
}
