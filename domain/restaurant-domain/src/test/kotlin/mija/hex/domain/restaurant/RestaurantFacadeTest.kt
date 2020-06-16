package mija.hex.domain.restaurant

import mija.hex.domain.restaurant.port.secondary.OrderDetails
import mija.hex.domain.restaurant.port.secondary.OrderNotification
import mija.hex.domain.restaurant.port.shared.OrderDetailsDto
import kotlin.test.Test
import kotlin.test.assertEquals

class RestaurantFacadeTest {

    @Test
    fun prepareOrderTest() {

        val set = mutableSetOf<Int>()
        val orderDetails = object : OrderDetails {
            override fun getOrderDetails(orderId: Int): OrderDetailsDto {
                return OrderDetailsDto(orderId, "pizza")
            }
        }
        val orderNotification = object : OrderNotification {
            override fun orderReady(orderId: Int) {
                set.add(orderId)
            }
        }
        val restaurantFacade: RestaurantFacade = RestaurantFacade(orderDetails, orderNotification)

        //When
        restaurantFacade.cookCommandService.prepareOrder(1)
        //Then
        assertEquals(1, set.first())

    }

}