package mija.hex.domain.order.infrastructure

import mija.hex.domain.order.infrastructure.port.secondary.Logistics
import mija.hex.domain.order.infrastructure.port.shared.OrderState
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class FoodOrderDomainTest {
    @Test
    fun createDomainTest() {
        //given
        val orderFacade = OrderFacade(createOrderStoreForTest(), createEmptyLogistic())
        //when
        val orderId: Int = orderFacade.foodOrderCommandService.createOrder("Burger", "ul. Balonowa")
        val orderDto = orderFacade.foodOrderQueryService.getOrderDetails(orderId)
        //then
        assertNotNull(orderId)
        assertEquals(OrderState.NEW, orderDto?.state)
    }

    @Test
    fun logisticsTest() {
        //given
        val logistics = MyLogistics()
        val orderFacade = OrderFacade(createOrderStoreForTest(), logistics)
        logistics.orderFacade = orderFacade
        val foodOrderCommandService = orderFacade.foodOrderCommandService
        val foodOrderQueryService = orderFacade.foodOrderQueryService
        //when
        val orderId: Int = foodOrderCommandService.createOrder("Burger", "ul. Balonowa")
        //then
        assertNotNull(orderId)
        assertEquals(OrderState.NEW, foodOrderQueryService.getOrderDetails(orderId)?.state)
        //when
        orderFacade.foodOrderCommandService.makeOrder()
        //then
        assertEquals(OrderState.READY_TO_DELIVERY, foodOrderQueryService.getOrderDetails(orderId)?.state)
        //when
        orderFacade.foodOrderCommandService.makeOrder()
        //then
        assertEquals(OrderState.DELIVERED, foodOrderQueryService.getOrderDetails(orderId)?.state)
    }
}

class MyLogistics() : Logistics {
    lateinit var orderFacade: OrderFacade

    override fun prepareOrder(orderId: Int) {
        orderFacade.foodOrderCommandService.markAsReadyToDelivery(orderId)
    }

    override fun deliver(orderId: Int) {
        orderFacade.foodOrderCommandService.markAsDelivered(orderId)
    }
}