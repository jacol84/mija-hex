package mija.hex.domain.order

import mija.hex.domain.order.port.primary.FoodOrderService
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderDto
import mija.hex.domain.order.port.shared.OrderState

internal class FoodOrderServiceImpl(private val orderStore: OrderStore) : FoodOrderService {

    override fun createOrder(disName: String, address: String): Int {
        val order = OrderFactory.createOrder(disName, address)
        orderStore.save(OrderFactory.toOrderDto(order))
        return order.orderId
    }

    override fun getOrderState(orderId: Int): OrderState? {
        val orderDto: OrderDto? = orderStore.load(orderId)
        return orderDto?.let {
            val order: Order = OrderFactory.from(it)
            order.state
        }
    }

    override fun changeOrderState(orderId: Int, newOrderState: OrderState) {
        val orderDto: OrderDto? = orderStore.load(orderId)
        orderDto?.let {
            val order: Order = OrderFactory.from(it)
            order.changeState(newOrderState)
            orderStore.save(OrderFactory.toOrderDto(order))
        }
    }

}