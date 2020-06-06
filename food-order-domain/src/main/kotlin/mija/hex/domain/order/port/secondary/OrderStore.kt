package mija.hex.domain.order.port.secondary

import mija.hex.domain.order.port.shared.OrderDto
import mija.hex.domain.order.port.shared.OrderState

interface OrderStore {
    fun save(dto: OrderDto)
    fun load(id: Int): OrderDto?
    fun findByState(state: OrderState):Collection<OrderDto>
}