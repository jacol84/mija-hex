package mija.hex.domain.order

import mija.hex.domain.order.port.shared.OrderState
import kotlin.test.Test
import kotlin.test.assertEquals

class DomainTest2 {

    @Test
    fun testNewBurger() {
        val orderFacade = OrderFacade(createOrderStoreForTest(), createEmptyLogistic())
        val orderId = orderFacade.foodOrderService.createOrder("Burger", "ul. Balonowa")
//        assertEquals(1, orderId) // FIXME how restart seq
        val orderState = orderFacade.foodOrderService.getOrderState(orderId)
        assertEquals(OrderState.NEW, orderState)
    }
}
