package mija.hex.domain.delivery


import mija.hex.domain.delivery.port.secondary.OrderDetails
import mija.hex.domain.delivery.port.secondary.OrderNotification
import mija.hex.domain.delivery.port.shared.OrderDetailsDto
import kotlin.test.Test
import kotlin.test.assertEquals

class DeliveryDomainTest {
    @Test
    fun deliveryTest() {
        val orderDetails = object : OrderDetails {

            override fun getOrderDetails(orderId: Int): OrderDetailsDto = OrderDetailsDto(orderId, "Wall Street 1 ")
        }
        val mapSender = mutableMapOf<Int, Boolean>()
        val orderNotification = object : OrderNotification {
            override fun orderReady(orderId: Int) {
                mapSender[orderId] = true
            }
        }

        val deliveryFacade = DeliveryFacade(orderDetails, orderNotification)

        //when
        deliveryFacade.deliveryCommandService.deliverOrder(1)
        //then
        assertEquals(true, mapSender.getOrDefault(1, false))
    }
}