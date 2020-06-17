package mija.hex.domain.restaurant.port.secondary

interface OrderNotification {
    fun orderReady(orderId: Int)
}