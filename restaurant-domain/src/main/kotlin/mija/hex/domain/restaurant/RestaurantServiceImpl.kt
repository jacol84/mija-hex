package mija.hex.domain.restaurant

import mija.hex.domain.restaurant.port.primary.RestaurantService
import mija.hex.domain.restaurant.port.secondary.OrderDetails
import mija.hex.domain.restaurant.port.secondary.OrderNotification
import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal class RestaurantServiceImpl(private val orderDetails: OrderDetails, private val orderNotification: OrderNotification) : RestaurantService {
    private val logger: Logger = LoggerFactory.getLogger(RestaurantServiceImpl::class.java)

    override fun prepareOrder(orderId: Int) {
        val dto = orderDetails.getOrderDetails(orderId)
        logger.info("Prepare dish ${dto.dishName}")
        orderNotification.orderReady(dto.orderId)
    }

}
