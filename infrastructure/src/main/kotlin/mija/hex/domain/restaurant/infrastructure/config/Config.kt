package mija.hex.domain.restaurant.infrastructure.config


import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import mija.hex.domain.restaurant.RestaurantFacade
import mija.hex.domain.restaurant.infrastructure.adapter.secondary.OrderDetailsAdapter
import mija.hex.domain.restaurant.port.secondary.OrderDetails
import mija.hex.domain.restaurant.port.secondary.OrderNotification
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("config-restaurant-domain")
class Config {
    @Bean
    fun restaurantFacade(orderDetails: OrderDetails, orderNotification: OrderNotification) = RestaurantFacade(orderDetails, orderNotification)

    @Bean("restaurant-order-details")
    fun orderDetails(foodOrderQueryService: FoodOrderQueryService): OrderDetails {
        return OrderDetailsAdapter(foodOrderQueryService)
    }

    @Bean
    fun orderNotification(): OrderNotification = TODO()

}