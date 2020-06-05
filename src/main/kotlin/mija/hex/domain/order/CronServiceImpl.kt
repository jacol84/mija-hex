package mija.hex.domain.order

import mija.hex.domain.order.port.primary.CronService
import mija.hex.domain.order.port.secondary.Logistics
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderState
import mija.hex.utils.logger

class CronServiceImpl(private val orderStore: OrderStore, private val logistics: Logistics) : CronService {


    override fun makeOrder() {
        val newOrders = orderStore.findByState(OrderState.NEW)
        val ready = orderStore.findByState(OrderState.READY_TO_DELIVERY)

        newOrders.forEach {
            logger().value.info("Preparing order ${it.orderId}")
            logistics.prepareOrder(it.orderId)
        }

        ready.forEach {
            logger().value.info("Delivering order $it.orderId")
            logistics.deliver(it.orderId)

        }
    }

}
