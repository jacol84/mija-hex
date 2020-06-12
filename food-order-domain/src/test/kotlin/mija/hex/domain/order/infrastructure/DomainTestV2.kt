package mija.hex.domain.order.infrastructure

import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
import mija.hex.domain.order.infrastructure.port.shared.OrderState
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class DomainTestV2 {

    @Test
    fun `simple domain test - use kotlin test - check status`() {
        //given
        val orderFacade = OrderFacade(createOrderStoreForTest(), createEmptyLogistic())
        val foodOrderCommandService: FoodOrderCommandService = orderFacade.foodOrderCommandService
        //when
        val orderId: Int = foodOrderCommandService.createOrder("Burger", "ul. Balonowa")
        val orderDto = orderFacade.foodOrderQueryService.getOrderDetails(orderId)
        //then
        assertEquals(OrderState.NEW, orderDto?.state)
    }

    @Test
    fun `simple domain test - use kotlin test - check exists in store and name is burger`() {
        //given
        val orderStore = createOrderStoreForTest()
        val orderFacade = OrderFacade(orderStore, createEmptyLogistic())
        val foodOrderCommandService: FoodOrderCommandService = orderFacade.foodOrderCommandService
        //given
        val orderId: Int = foodOrderCommandService.createOrder("Burger", "ul. Balonowa")
        //then
        val orderDto = orderFacade.foodOrderQueryService.getOrderDetails(orderId)
        assertEquals(OrderState.NEW, orderDto?.state)
        val dto = orderStore.load(orderId)
        assertNotNull(dto)
        assertEquals("Burger", dto.disName)
    }

    @Test
    fun `simple domain test - use kotlin test - check status when id not exists in store`() {
        //given
        val orderFacade = OrderFacade(createOrderStoreForTest(), createEmptyLogistic())
        val foodOrderCommandService: FoodOrderCommandService = orderFacade.foodOrderCommandService
        //given
        val orderId: Int = -15
        //then
        val orderDto = orderFacade.foodOrderQueryService.getOrderDetails(orderId)
        assertNull(orderDto?.state)
    }
}
