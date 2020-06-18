package mija.hex.infrastructure.app.order.adapter.primary.rest

import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import mija.hex.domain.order.infrastructure.port.shared.OrderDto
import mija.hex.infrastructure.app.order.api.OrderDetailsResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("food-orders")
class FoodOrderEndpoint(private val foodOrderQueryService: FoodOrderQueryService) {
    @RequestMapping("{orderId}")
    fun getOrderDetails(@PathVariable orderId: Int): ResponseEntity<OrderDetailsResponse> {
        //TODO add validation
        val response = foodOrderQueryService.getOrderDetails(orderId)?.toOrderDetailsResponse()
        return if(response ==null) ResponseEntity.notFound().build() else ResponseEntity.ok(response)
    }

}

private fun OrderDto.toOrderDetailsResponse() = OrderDetailsResponse(orderId, address, disName)
