package mija.hex.domain.order

import mija.hex.domain.order.port.primary.FoodOrderService
import mija.hex.domain.order.port.shared.OrderState
import java.util.concurrent.atomic.AtomicInteger

class FoodOrderServiceImpl : FoodOrderService {

    companion object {
        var Sequence = AtomicInteger()
    }

    override fun createOrder(disName: String): Int {
        val order = Order(Sequence.getAndIncrement(), disName, OrderState.NEW)
        return order.orderId
    }

    override fun getOrderState(disName: String): OrderState {
        return OrderState.NEW
    }

}