package mija.hex.domain.delivery.port.secondary

import mija.hex.domain.delivery.port.shared.OrderDetailsDto

interface OrderDetails {
    fun getOrderDetails(orderId: Int): OrderDetailsDto
}