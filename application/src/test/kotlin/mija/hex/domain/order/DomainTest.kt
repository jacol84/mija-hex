package mija.hex.domain.order

import mija.hex.domain.order.port.primary.FoodOrderService
import mija.hex.domain.order.port.shared.OrderState
import kotlin.test.Test

class DomainTest {
    @Test
    fun `simple domain test`() {
        val orderFacade = OrderFacade(createOrderStoreForTest(), createEmptyLogistic())
        val foodOrderService: FoodOrderService = orderFacade.foodOrderService
        val orderId: Int = foodOrderService.createOrder("Burger", "ul. Balonowa")
        println("OrderId: $orderId")
        val orderState: OrderState? = foodOrderService.getOrderState(orderId)
        println("OrderState: $orderState")

    }
}
