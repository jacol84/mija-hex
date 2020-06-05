package mija.hex.domain.delivery

import mija.hex.domain.delivery.port.primary.DeliveryService
import mija.hex.domain.delivery.port.secondary.OrderDetails
import mija.hex.domain.delivery.port.secondary.OrderNotification
import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal class DeliveryServiceImpl(private val orderDetails: OrderDetails, private val orderNotification: OrderNotification) : DeliveryService {


    private val logger: Logger = LoggerFactory.getLogger(DeliveryServiceImpl::class.java)

    override fun deliveryOrder(orderId: Int) {
        val dto = orderDetails.getOrderDetails(orderId)
        logger.info("deliveryOrder $dto")
        orderNotification.orderReady(dto.orderId)
    }
}