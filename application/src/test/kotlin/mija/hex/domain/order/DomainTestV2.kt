package mija.hex.domain.order

import mija.hex.domain.order.port.primary.FoodOrderService
import mija.hex.domain.order.port.shared.OrderState
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class DomainTestV2 {

    @Test
    fun `simple domain test - use kotlin test - check status`() {
        //given
        val orderFacade = OrderFacade(createOrderStoreForTest(), createEmptyLogistic())
        val foodOrderService: FoodOrderService = orderFacade.foodOrderService
        //given
        val orderId: Int = foodOrderService.createOrder("Burger", "ul. Balonowa")
        //then
        val orderState: OrderState? = foodOrderService.getOrderState(orderId)
        assertEquals(OrderState.NEW, orderState)
    }

    @Test
    fun `simple domain test - use kotlin test - check exists in store and name is burger`() {
        //given
        val orderStore = createOrderStoreForTest()
        val orderFacade = OrderFacade(orderStore, createEmptyLogistic())
        val foodOrderService: FoodOrderService = orderFacade.foodOrderService
        //given
        val orderId: Int = foodOrderService.createOrder("Burger", "ul. Balonowa")
        //then
        val orderState: OrderState? = foodOrderService.getOrderState(orderId)
        assertEquals(OrderState.NEW, orderState)
        val dto = orderStore.load(orderId)
        assertNotNull(dto)
        assertEquals("Burger", dto.disName)
    }

    @Test
    fun `simple domain test - use kotlin test - check status when id not exists in store`() {
        //given
        val orderFacade = OrderFacade(createOrderStoreForTest(), createEmptyLogistic())
        val foodOrderService: FoodOrderService = orderFacade.foodOrderService
        //given
        val orderId: Int = -15
        //then
        val orderState: OrderState? = foodOrderService.getOrderState(orderId)
        assertNull(orderState)
    }
}
