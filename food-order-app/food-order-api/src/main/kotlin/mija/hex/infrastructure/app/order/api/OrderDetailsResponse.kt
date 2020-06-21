package mija.hex.infrastructure.app.order.api

//TODO mija.hex.infrastructure.app.delivery.adpater.secondary.FoodOrderDetailsRestAdapter.getOrderDetails not working when field not declared
data class OrderDetailsResponse constructor(val orderId: Int = 1, val address: String = "", val dishName: String = "")