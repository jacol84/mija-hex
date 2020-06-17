package app.delivery.config

import mija.hex.domain.delivery.port.primary.DeliveryCommandService
import mija.hex.infrastructure.CommandHandler
import mija.hex.infrastructure.command.Command
import mija.hex.infrastructure.command.DeliverOrderCommand
import org.springframework.context.annotation.Configuration

@Configuration
internal class DeliverOrderCommandHandler(private val deliveryCommandService: DeliveryCommandService) : CommandHandler<DeliverOrderCommand> {
    override fun handle(command: Command) {
        deliveryCommandService.deliverOrder(command.orderId)
    }

    override fun getCommandClass() = DeliverOrderCommand::class
}