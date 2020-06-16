package mija.hex.domain.order.infrastructure.port.primary

interface FoodOrderCommandService {
    fun createOrder(disName: String, address: String): Int
    fun markAsReadyToDelivery(orderId: Int)
    fun markAsDelivered(orderId: Int)
    fun makeOrder()
}