package mija.hex.domain.order

import mija.hex.domain.order.port.secondary.Logistics
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

        override fun findByState(state: OrderState): Collection<OrderDto> {
            println("findByState::load: $state")
            return memory.filter { it.value.state == state }.values
        }
    }
    private val logistics: Logistics = object : Logistics {
        override fun prepareOrder(orderId: Int) {
            TODO("Not yet implemented")
        }

        override fun deliver(orderId: Int) {
            TODO("Not yet implemented")
        }
    }

    @Test
    fun testNewBurger() {
        val orderFacade = OrderFacade(oderStore, logistics)
        val orderId = orderFacade.foodOrderService.createOrder("Burger", "ul. Balonowa")
//        assertEquals(1, orderId)
        val orderState = orderFacade.foodOrderService.getOrderState(orderId)
        assertEquals(OrderState.NEW, orderState)
    }
}
