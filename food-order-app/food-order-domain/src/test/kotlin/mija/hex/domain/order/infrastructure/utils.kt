package mija.hex.domain.order.infrastructure

import mija.hex.domain.order.infrastructure.port.secondary.Logistics
import mija.hex.domain.order.infrastructure.port.secondary.OrderStore
import mija.hex.domain.order.infrastructure.port.shared.OrderDto
import mija.hex.domain.order.infrastructure.port.shared.OrderState

fun createEmptyLogistic() = object : Logistics {
    override fun prepareOrder(orderId: Int) {
        TODO("Not yet implemented")
    }

    override fun deliver(orderId: Int) {
        TODO("Not yet implemented")
    }
}

fun createOrderStoreForTest() = object : OrderStore {
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