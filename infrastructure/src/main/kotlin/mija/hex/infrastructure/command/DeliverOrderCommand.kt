package mija.hex.infrastructure.command

import mija.hex.domain.delivery.port.primary.DeliveryCommandService
import mija.hex.infrastructure.CommandHandler
import org.springframework.context.annotation.Configuration

data class DeliverOrderCommand(override val orderId: Int) : Command


@Configuration
class DeliverOrderCommandHandler(private val deliveryCommandService: DeliveryCommandService) : CommandHandler<DeliverOrderCommand> {
    override fun handle(command: Command) {
        deliveryCommandService.deliverOrder(command.orderId)
    }
    override fun getCommandClass() =  DeliverOrderCommand::class
}