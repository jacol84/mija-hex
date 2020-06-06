package mija.hex

import mija.hex.domain.order.OrderFacade
import mija.hex.domain.order.port.secondary.Logistics
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderDto
import mija.hex.domain.order.port.shared.OrderState
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@Ignore
class CrossDomainTest {

    private val oderStore: OrderStore = object : OrderStore {
        val memory: MutableMap<Int, OrderDto> = mutableMapOf()
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
    private val logistics: Logistics = object : Logistics {

        override fun prepareOrder(orderId: Int) {
            println("Logistics::prepareOrder: $orderId")
        }

        override fun deliver(orderId: Int) {
            println("Logistics::deliver: $orderId")
        }
    }

    @Test
    fun crossDomain() {
        //given
        val orderFacade = OrderFacade(oderStore, logistics)
        val foodOrderCommandService = orderFacade.foodOrderCommandService
        val foodOrderQueryService = orderFacade.foodOrderQueryService

        //when
        val orderId = foodOrderCommandService.createOrder("Pizza", "ul. Balonowa")
        val orderDto = foodOrderQueryService.getOrderDetails(orderId)

        //then
        assertNotNull(orderId)
        assertEquals(OrderState.NEW, orderDto?.state)

        //when
        orderFacade.foodOrderCommandService.makeOrder()
        val orderDtoReady = foodOrderQueryService.getOrderDetails(orderId)
        //then
        assertEquals(OrderState.READY_TO_DELIVERY, orderDtoReady?.state)

        //when
        orderFacade.foodOrderCommandService.makeOrder()
        val orderDtoDelivered = foodOrderQueryService.getOrderDetails(orderId)
        //then
        assertEquals(OrderState.DELIVERED, orderDtoDelivered?.state)
    }
}