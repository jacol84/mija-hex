package mija.hex.infrastructure.app.restaurant.adapter.secondary

import mija.hex.domain.restaurant.RestaurantFacade
import mija.hex.domain.restaurant.port.secondary.OrderDetails
import mija.hex.domain.restaurant.port.secondary.OrderNotification
import mija.hex.infrastructure.CommandBus
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration("config-restaurant-domain")
class Config {

    @Bean
    fun restaurantFacade(orderDetails: OrderDetails, orderNotification: OrderNotification) = RestaurantFacade(orderDetails, orderNotification)


    @Bean("restaurant-order-details")
    fun orderDetails(
            @Qualifier("food-order-service-restaurant-rest-template") restTemplate: RestTemplate,
            @Value("\${endpoint.foodOrderEndpointURL}") url: String
    ): OrderDetails {
        return FoodOrderDetailsRestAdapter(restTemplate, url)
    }

    @Bean
    fun restaurantOrderNotification(commandBus: CommandBus): OrderNotification = OrderNotificationAdapter(commandBus)

    @Bean("food-order-service-restaurant-rest-template")
    fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate {
        return restTemplateBuilder.build()
    }
}