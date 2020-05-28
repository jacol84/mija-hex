package mija.hex.domain.order

import mija.hex.domain.order.port.primary.FoodOrderService
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderDto
import mija.hex.domain.order.port.shared.OrderState
import org.junit.Test

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
        }

        val orderFacade = OrderFacade(oderStore)
        val foodOrderService: FoodOrderService = orderFacade.getFoodOrderService()
        val orderId: Int = foodOrderService.createOrder("Burger")
        println("OrderId: $orderId")
        val orderState: OrderState? = foodOrderService.getOrderState(orderId)
        println("OrderState: $orderState")
    }
}
