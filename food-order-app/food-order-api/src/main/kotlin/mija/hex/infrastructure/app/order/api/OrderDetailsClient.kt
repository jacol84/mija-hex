package mija.hex.infrastructure.app.order.api

interface OrderDetailsClient {
    fun getOrderDetails(orderId: Int): OrderDetailsResponse
}