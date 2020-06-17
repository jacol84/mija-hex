package mija.hex.infrastructure.app.order.api

data class OrderDetailsResponse(val orderId: Int, val address: String, val dishName: String)