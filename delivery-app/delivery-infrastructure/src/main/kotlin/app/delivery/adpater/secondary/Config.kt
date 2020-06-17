package app.delivery.adpater.secondary

import mija.hex.domain.delivery.DeliveryFacade
import mija.hex.domain.delivery.port.secondary.OrderDetails
import mija.hex.domain.delivery.port.secondary.OrderNotification
import mija.hex.domain.order.infrastructure.port.primary.FoodOrderQueryService
import mija.hex.infrastructure.CommandBus
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
    fun orderNotification(commandBus: CommandBus): OrderNotification = OrderNotificationAdapter(commandBus)

}