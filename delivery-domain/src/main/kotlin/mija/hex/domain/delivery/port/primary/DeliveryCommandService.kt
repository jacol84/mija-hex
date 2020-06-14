package mija.hex.domain.delivery.port.primary

interface DeliveryCommandService {
    fun deliverOrder(orderId: Int)
}