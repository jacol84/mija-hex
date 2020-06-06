package mija.hex.domain.order.port.secondary

interface Logistics {
    fun prepareOrder(orderId: Int)
    fun deliver(orderId: Int)
}