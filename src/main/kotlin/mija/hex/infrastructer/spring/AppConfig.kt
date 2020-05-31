package mija.hex.infrastructer.spring

import mija.hex.domain.order.OrderFacade
import mija.hex.domain.order.port.secondary.OrderStore
import mija.hex.domain.order.port.shared.OrderDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    private val logger: Logger = LoggerFactory.getLogger(AppConfig::class.java)

    @Bean
    fun orderFacade(orderStore: OrderStore) = OrderFacade(orderStore)

    @Bean
    fun orderStore(): OrderStore =
            object : OrderStore {
                private val memory: MutableMap<Int, OrderDto> = mutableMapOf()
                override fun save(dto: OrderDto) {
                    logger.info("OrderStore::save: ${dto.orderId}")
                    memory[dto.orderId] = dto
                }

                override fun load(id: Int): OrderDto? {
                    logger.info("OrderStore::load: $id")
                    return memory[id]
                }
            }


}