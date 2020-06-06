package mija.hex.domain.order

import mija.hex.domain.order.port.primary.FoodOrderCommandService
import mija.hex.domain.order.port.secondary.Logistics
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderDto
import mija.hex.domain.order.port.shared.OrderState
import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal class FoodOrderCommandServiceImpl(private val orderStore: OrderStore, private val logistics: Logistics) : FoodOrderCommandService {

    override fun createOrder(disName: String, address: String): Int {
        val order = OrderFactory.createOrder(disName, address)
        orderStore.save(OrderFactory.toOrderDto(order))
        return order.orderId
    }

    override fun markAsReadyToDelivery(orderId: Int) {
        changeOrderState(orderId, OrderState.READY_TO_DELIVERY)
    }

    override fun markAsDelivered(orderId: Int) {
        changeOrderState(orderId, OrderState.DELIVERED)
    }

    override fun makeOrder() {
        val newOrders = orderStore.findByState(OrderState.NEW)
        val ready = orderStore.findByState(OrderState.READY_TO_DELIVERY)

        newOrders.forEach {
            logger().info("Preparing order ${it.orderId}")
            logistics.prepareOrder(it.orderId)
        }

        ready.forEach {
            logger().info("Delivering order $it.orderId")
            logistics.deliver(it.orderId)

        }
    }

    private fun changeOrderState(orderId: Int, newOrderState: OrderState) {
        val orderDto: OrderDto? = orderStore.load(orderId)
        orderDto?.let {
            val order: Order = OrderFactory.from(it)
            order.changeState(newOrderState)
            orderStore.save(OrderFactory.toOrderDto(order))
        }
    }

}


fun <R : Any> R.logger(): Logger {
    return LoggerFactory.getLogger(this::class.java.name)
}
