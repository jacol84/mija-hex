package mija.hex.domain.restaurant

import mija.hex.domain.restaurant.port.primary.RestaurantService
import mija.hex.domain.restaurant.port.secondary.OrderDetails
import mija.hex.domain.restaurant.port.secondary.OrderNotification

class RestaurantFacade(private val orderDetails: OrderDetails, private val orderNotification: OrderNotification) {
    val restaurantService: RestaurantService = RestaurantServiceImpl(orderDetails, orderNotification)
}