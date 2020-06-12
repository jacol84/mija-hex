package mija.hex.domain.delivery.infrastructure.config

import mija.hex.domain.delivery.DeliveryFacade
import mija.hex.domain.delivery.infrastructure.adapter.secondary.OrderDetailsAdapter
import mija.hex.domain.delivery.infrastructure.adapter.secondary.OrderNotificationAdapter
import mija.hex.domain.delivery.port.secondary.OrderDetails
import mija.hex.domain.delivery.port.secondary.OrderNotification
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("config-delivery-domain")
class Config {
    @Bean
    fun deliveryFacade(orderDetails: OrderDetails, orderNotification: OrderNotification) = DeliveryFacade(orderDetails, orderNotification)

    @Bean("delivery-order-details")
    fun orderDetails(foodOrderQueryService: FoodOrderQueryService): OrderDetails  {
        return OrderDetailsAdapter(foodOrderQueryService)
    }

    @Bean
    fun orderNotification(applicationEventPublisher: ApplicationEventPublisher): OrderNotification = OrderNotificationAdapter(applicationEventPublisher)

}