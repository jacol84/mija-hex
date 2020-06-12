package mija.hex.domain.order.infrastructure.port.secondary

interface Logistics {
    fun prepareOrder(orderId: Int)
    fun deliver(orderId: Int)
}