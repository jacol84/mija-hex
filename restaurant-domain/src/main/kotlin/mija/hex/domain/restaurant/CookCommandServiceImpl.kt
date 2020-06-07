package mija.hex.domain.restaurant

import mija.hex.domain.restaurant.port.primary.CookCommandService
import mija.hex.domain.restaurant.port.secondary.OrderDetails
import mija.hex.domain.restaurant.port.secondary.OrderNotification
import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal class CookCommandServiceImpl(private val orderDetails: OrderDetails, private val orderNotification: OrderNotification) : CookCommandService {
    private val logger: Logger = LoggerFactory.getLogger(CookCommandServiceImpl::class.java)

    override fun prepareOrder(orderId: Int) {
        val dto = orderDetails.getOrderDetails(orderId)
        logger.info("Prepare dish ${dto.dishName}")
        orderNotification.orderReady(dto.orderId)
    }

}
