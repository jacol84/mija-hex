package mija.hex.domain.order

import mija.hex.domain.order.port.primary.CronService
import mija.hex.domain.order.port.secondary.Logistics
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderState

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CronServiceImpl(private val orderStore: OrderStore, private val logistics: Logistics) : CronService {


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


}


fun <R : Any> R.logger(): Logger {
    return LoggerFactory.getLogger(this::class.java.name)
}
