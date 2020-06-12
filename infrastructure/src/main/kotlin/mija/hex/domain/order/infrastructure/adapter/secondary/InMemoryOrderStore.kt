package mija.hex.domain.order.infrastructure.adapter.secondary

import mija.hex.domain.order.infrastructure.port.secondary.OrderStore
import mija.hex.domain.order.infrastructure.port.shared.OrderDto
import mija.hex.domain.order.infrastructure.port.shared.OrderState
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class InMemoryOrderStore : OrderStore {
    private val logger: Logger = LoggerFactory.getLogger(InMemoryOrderStore::class.java)

    private val memory: MutableMap<Int, OrderDto> = mutableMapOf()
    override fun save(dto: OrderDto) {
        logger.info("OrderStore::save: ${dto.orderId}")
        memory[dto.orderId] = dto
    }

    override fun load(id: Int): OrderDto? {
        logger.info("OrderStore::load: $id")
        return memory[id]
    }

    override fun findByState(state: OrderState): Collection<OrderDto> {
        logger.info("OrderStore::findByState: $state")
        return memory.filter { it.value.state == state }.values
    }
}