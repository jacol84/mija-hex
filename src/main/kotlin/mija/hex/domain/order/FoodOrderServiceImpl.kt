package mija.hex.domain.order

import mija.hex.domain.order.port.primary.FoodOrderService
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderDto
import mija.hex.domain.order.port.shared.OrderState
import java.util.concurrent.atomic.AtomicInteger

internal class FoodOrderServiceImpl(private val orderStore: OrderStore) : FoodOrderService {

    companion object {
        var Sequence = AtomicInteger()
    }

    override fun createOrder(disName: String): Int {
        val order = OrderFactory.createOrder(disName)
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

}