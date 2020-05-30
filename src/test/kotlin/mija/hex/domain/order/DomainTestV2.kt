package mija.hex.domain.order

import mija.hex.domain.order.port.primary.FoodOrderService
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderDto
import mija.hex.domain.order.port.shared.OrderState
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class DomainTestV2 {
    private val oderStore: OrderStore = object : OrderStore {
        private val memory: MutableMap<Int, OrderDto> = mutableMapOf()
        override fun save(dto: OrderDto) {
            println("OrderStore::save: ${dto.orderId}")
            memory[dto.orderId] = dto
        }

        override fun load(id: Int): OrderDto? {
            println("OrderStore::load: $id")
            return memory[id]
        }
    }

    @Test
    fun `simple domain test - use kotlin test - check status`() {
        //given
        val orderFacade = OrderFacade(oderStore)
        val foodOrderService: FoodOrderService = orderFacade.getFoodOrderService()
        //given
        val orderId: Int = foodOrderService.createOrder("Burger")
        //then
        val orderState: OrderState? = foodOrderService.getOrderState(orderId)
        assertEquals(OrderState.NEW, orderState)
    }

    @Test
    fun `simple domain test - use kotlin test - check exists in store and name is burger`() {
        //given
        val orderFacade = OrderFacade(oderStore)
        val foodOrderService: FoodOrderService = orderFacade.getFoodOrderService()
        //given
        val orderId: Int = foodOrderService.createOrder("Burger")
        //then
        val orderState: OrderState? = foodOrderService.getOrderState(orderId)
        assertEquals(OrderState.NEW, orderState)
        val dto = oderStore.load(orderId)
        assertNotNull(dto)
        assertEquals("Burger", dto.dishName)
    }

    @Test
    fun `simple domain test - use kotlin test - check status when id not exists in store`() {
        //given
        val orderFacade = OrderFacade(oderStore)
        val foodOrderService: FoodOrderService = orderFacade.getFoodOrderService()
        //given
        val orderId: Int = -15
        //then
        val orderState: OrderState? = foodOrderService.getOrderState(orderId)
        assertNull(orderState)
    }
}
