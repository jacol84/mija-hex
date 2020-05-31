package mija.hex.infrastructer.domain.order.adapter.secondary

import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderDto
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
}