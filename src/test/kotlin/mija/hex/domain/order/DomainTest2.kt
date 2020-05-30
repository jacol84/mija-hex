package mija.hex.domain.order

import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderDto
import mija.hex.domain.order.port.shared.OrderState
import kotlin.test.Test
import kotlin.test.assertEquals

class DomainTest2 {
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
    fun testNewBurger () {
        val orderFacade = OrderFacade(oderStore)
        val orderId = orderFacade.getFoodOrderService().createOrder("Burger")
//        assertEquals(1, orderId)
        var orderState = orderFacade.getFoodOrderService().getOrderState(orderId)
        assertEquals(OrderState.NEW, orderState)
    }
}
