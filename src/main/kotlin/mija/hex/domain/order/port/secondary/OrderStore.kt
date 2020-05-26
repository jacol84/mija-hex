package mija.hex.domain.order.port.secondary

import mija.hex.domain.order.port.shared.OrderDto

interface OrderStore {
    fun save(dto: OrderDto)
    fun load(id: Int): OrderDto
}