package mija.hex.infrastructure.app.order.adapter.secondary

import mija.hex.domain.order.infrastructure.OrderFacade
import mija.hex.domain.order.infrastructure.port.secondary.Logistics
import mija.hex.domain.order.infrastructure.port.secondary.OrderStore
import mija.hex.infrastructure.CommandBus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration("config-food-order-domain")
internal class Config {
    @Bean
    fun orderFacade(orderStore: OrderStore, logistics: Logistics) = OrderFacade(orderStore, logistics)

    @Bean
    fun orderStore(): OrderStore = InMemoryOrderStore()

    @Bean
    fun getLogistics(commandBus: CommandBus): Logistics = TrueLogistics(commandBus)
}