package mija.hex.domain.restaurant.infrastructure.adapter.secondary

import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import mija.hex.domain.order.infrastructure.port.shared.OrderDto
import mija.hex.domain.restaurant.port.secondary.OrderDetails
import mija.hex.domain.restaurant.port.shared.OrderDetailsDto

class OrderDetailsAdapter(private val foodOrderQueryService: FoodOrderQueryService) : OrderDetails {

    //FIXME !!
    override fun getOrderDetails(orderId: Int): OrderDetailsDto {
        return foodOrderQueryService.getOrderDetails(orderId)?.toOrderDetailsDto()!!
    }

}

private fun OrderDto.toOrderDetailsDto(): OrderDetailsDto = OrderDetailsDto(orderId, disName)
