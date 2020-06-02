package mija.hex.domain.restaurant.port.primary

interface RestaurantService {
    fun prepareOrder(orderId:Int)
}