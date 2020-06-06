package mija.hex.domain.order

import mija.hex.domain.order.port.shared.OrderState
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class FoodOrderDomainTest {
    @Test
    fun createDomainTest() {
        //given
        val orderFacade = OrderFacade(createOrderStoreForTest(), createEmptyLogistic())
        val foodOrderCommandService = orderFacade.foodOrderCommandService
        val foodOrderQueryService = orderFacade.foodOrderQueryService
        //when
        val orderId: Int = foodOrderCommandService.createOrder("Burger", "ul. Balonowa")
        val orderDto = foodOrderQueryService.getOrderDetails(orderId)


        //then
        assertNotNull(orderId)
        assertEquals(OrderState.NEW, orderDto?.state)

    }

}