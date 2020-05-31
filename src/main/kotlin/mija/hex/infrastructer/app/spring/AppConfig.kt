package mija.hex.infrastructer.app.spring

import mija.hex.domain.order.OrderFacade
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.infrastructer.domain.order.adapter.secondary.InMemoryOrderStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun orderFacade(orderStore: OrderStore) = OrderFacade(orderStore)

    @Bean
    fun orderStore(): OrderStore = InMemoryOrderStore()

}