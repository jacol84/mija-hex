package mija.hex.infrastructure.app.delivery.adpater.secondary

import mija.hex.domain.delivery.port.secondary.OrderDetails
import mija.hex.domain.delivery.port.shared.OrderDetailsDto
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import mija.hex.domain.order.infrastructure.port.shared.OrderDto

internal class OrderDetailsAdapter(private val foodOrderQueryService: FoodOrderQueryService) : OrderDetails {

    //FIXME !!
    override fun getOrderDetails(orderId: Int): OrderDetailsDto {
        return foodOrderQueryService.getOrderDetails(orderId)?.toOrderDetailsDto()!!
    }

}

private fun OrderDto.toOrderDetailsDto(): OrderDetailsDto = OrderDetailsDto(orderId, address)
