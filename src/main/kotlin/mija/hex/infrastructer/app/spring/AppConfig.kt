package mija.hex.infrastructer.app.spring

import mija.hex.domain.order.OrderFacade
import mija.hex.domain.order.port.secondary.Logistics
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.infrastructer.domain.order.adapter.secondary.InMemoryOrderStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun orderFacade(orderStore: OrderStore, logistics: Logistics) = OrderFacade(orderStore, logistics)

    @Bean
    fun orderStore(): OrderStore = InMemoryOrderStore()

    @Bean
    fun getLogistics(): Logistics = object : Logistics {
        override fun prepareOrder(orderId: Int) {
            TODO("Not yet implemented")
        }

        override fun deliver(orderId: Int) {
            TODO("Not yet implemented")
        }
    }
}