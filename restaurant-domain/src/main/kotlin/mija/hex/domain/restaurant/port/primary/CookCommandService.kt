package mija.hex.domain.restaurant.port.primary

interface CookCommandService {
    fun prepareOrder(orderId:Int)
}