package app.delivery.adpater.secondary

import mija.hex.domain.delivery.port.secondary.OrderDetails
import mija.hex.domain.delivery.port.shared.OrderDetailsDto
import mija.hex.infrastructure.app.order.api.OrderDetailsResponse
import org.springframework.web.client.RestTemplate


internal class FoodOrderDetailsRestAdapter(private val restTemplate: RestTemplate, private val url: String) : OrderDetails {

    //FIXME !!
    override fun getOrderDetails(orderId: Int): OrderDetailsDto {
        val details = restTemplate.getForObject(url, OrderDetailsResponse::class.java, orderId)
        return details?.toOrderDetailsDto() ?: wrong(orderId, url)
    }

    private fun wrong(orderId: Int, url: String): Nothing {
        throw IllegalArgumentException("not found for $orderId -> $url")
    }

}

private fun OrderDetailsResponse.toOrderDetailsDto(): OrderDetailsDto = OrderDetailsDto(orderId, address)
