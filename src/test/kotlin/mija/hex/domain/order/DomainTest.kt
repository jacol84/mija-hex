package mija.hex.domain.order

import mija.hex.domain.order.port.primary.FoodOrderService
import mija.hex.domain.order.port.secondary.Logistics
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderDto
import mija.hex.domain.order.port.shared.OrderState
import kotlin.test.Test

class DomainTest {
    @Test
    fun `simple domain test`() {
        val oderStore: OrderStore = object : OrderStore {

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
                println("OrderStore::findByState: $state")
                return memory.filter { it.value.state == state }.values
            }
        }
        val logistics: Logistics = object : Logistics {
            override fun prepareOrder(orderId: Int) {
                TODO("Not yet implemented")
            }

            override fun deliver(orderId: Int) {
                TODO("Not yet implemented")
            }
        }


        val orderFacade = OrderFacade(oderStore, logistics)
        val foodOrderService: FoodOrderService = orderFacade.foodOrderService
        val orderId: Int = foodOrderService.createOrder("Burger", "ul. Balonowa")
        println("OrderId: $orderId")
        val orderState: OrderState? = foodOrderService.getOrderState(orderId)
        println("OrderState: $orderState")
    }
}
