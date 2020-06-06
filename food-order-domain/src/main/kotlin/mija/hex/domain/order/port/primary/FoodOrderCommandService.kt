package mija.hex.domain.order.port.primary

interface FoodOrderCommandService {
    fun createOrder(disName: String, address: String): Int
    fun markAsReadyToDelivery(orderId: Int)
    fun markAsDelivered(orderId: Int)
    fun makeOrder()

}