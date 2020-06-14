package mija.hex.domain.delivery

import mija.hex.domain.delivery.port.primary.DeliveryCommandService
import mija.hex.domain.delivery.port.secondary.OrderDetails
import mija.hex.domain.delivery.port.secondary.OrderNotification
import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal class DeliveryCommandServiceImpl(private val orderDetails: OrderDetails, private val orderNotification: OrderNotification) : DeliveryCommandService {


    private val logger: Logger = LoggerFactory.getLogger(DeliveryCommandServiceImpl::class.java)

    override fun deliverOrder(orderId: Int) {
        val dto = orderDetails.getOrderDetails(orderId)
        logger.info("deliveryOrder $dto")
        orderNotification.orderReady(dto.orderId)
    }
}