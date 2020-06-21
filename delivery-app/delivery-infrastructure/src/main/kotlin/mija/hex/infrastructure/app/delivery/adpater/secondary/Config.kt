package mija.hex.infrastructure.app.delivery.adpater.secondary

import mija.hex.domain.delivery.DeliveryFacade
import mija.hex.domain.delivery.port.secondary.OrderDetails
import mija.hex.domain.delivery.port.secondary.OrderNotification

import mija.hex.infrastructure.CommandBus
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration("config-delivery-domain")
class Config {
    @Bean
    fun deliveryFacade(orderDetails: OrderDetails, orderNotification: OrderNotification) = DeliveryFacade(orderDetails, orderNotification)

    @Bean("delivery-order-details")
    fun orderDetails(
            @Qualifier("food-order-service--delivery-rest-template") restTemplate: RestTemplate,
            @Value("\${endpoint.foodOrderEndpointURL}") url: String
    ): OrderDetails {
        return FoodOrderDetailsRestAdapter(restTemplate, url)
    }

    @Bean
    fun orderNotification(commandBus: CommandBus): OrderNotification = OrderNotificationAdapter(commandBus)

    @Bean("food-order-service--delivery-rest-template")
    fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate {
        return restTemplateBuilder.build()
    }

}