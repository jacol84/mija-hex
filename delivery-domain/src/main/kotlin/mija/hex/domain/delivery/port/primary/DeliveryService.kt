package mija.hex.domain.delivery.port.primary

interface DeliveryService {
    fun deliveryOrder(orderId: Int)
}