package mija.hex.domain.order.infrastructure

import mija.hex.domain.order.infrastructure.port.shared.OrderState
import kotlin.test.Test
import kotlin.test.assertEquals

class DomainTest2 {

    @Test
    fun testNewBurger() {
        val orderFacade = OrderFacade(createOrderStoreForTest(), createEmptyLogistic())
        val orderId = orderFacade.foodOrderCommandService.createOrder("Burger", "ul. Balonowa")
//        assertEquals(1, orderId) // FIXME how restart seq
        val orderDto = orderFacade.foodOrderQueryService.getOrderDetails(orderId)
        assertEquals(OrderState.NEW, orderDto?.state)
    }
}
