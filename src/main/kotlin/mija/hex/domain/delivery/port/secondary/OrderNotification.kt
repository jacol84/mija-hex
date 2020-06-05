package mija.hex.domain.delivery.port.secondary

interface OrderNotification {
    fun orderReady(orderId: Int)
}