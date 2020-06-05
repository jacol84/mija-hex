package mija.hex.domain.restaurant.port.secondary

import mija.hex.domain.restaurant.port.shared.OrderDetailsDto

interface OrderDetails {
    fun getOrderDetails(orderId: Int): OrderDetailsDto
}