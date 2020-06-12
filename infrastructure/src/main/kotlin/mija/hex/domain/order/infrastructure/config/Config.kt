package mija.hex.domain.order.infrastructure.config

import mija.hex.domain.delivery.port.primary.DeliveryCommandService
import mija.hex.domain.order.infrastructure.OrderFacade
import mija.hex.domain.order.infrastructure.adapter.secondary.InMemoryOrderStore
import mija.hex.domain.order.infrastructure.adapter.secondary.TrueLogistics
import mija.hex.domain.order.infrastructure.port.secondary.Logistics
import mija.hex.domain.order.infrastructure.port.secondary.OrderStore
import mija.hex.domain.restaurant.port.primary.CookCommandService
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("config-food-order-domain")
class Config {
    @Bean
    fun orderFacade(orderStore: OrderStore, logistics: Logistics) = OrderFacade(orderStore, logistics)

    @Bean
    fun orderStore(): OrderStore = InMemoryOrderStore()

    @Bean
    fun getLogistics(applicationEventPublisher: ApplicationEventPublisher): Logistics = TrueLogistics(applicationEventPublisher)
}