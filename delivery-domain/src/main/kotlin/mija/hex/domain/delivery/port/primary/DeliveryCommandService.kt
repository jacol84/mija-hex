package mija.hex.domain.delivery.port.primary

interface DeliveryCommandService {
    fun deliveryOrder(orderId: Int)
}