package mija.hex.infrastructure.app.order.config

import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
import mija.hex.infrastructure.CommandHandler
import mija.hex.infrastructure.command.Command
import mija.hex.infrastructure.command.MarkOrderAsReadyToDeliveryCommand
import org.springframework.context.annotation.Configuration

@Configuration
internal class MarkOrderAsReadyToDeliveryCommandHandler(private val foodOrderCommandService: FoodOrderCommandService) : CommandHandler<MarkOrderAsReadyToDeliveryCommand> {
    override fun handle(command: Command) {
        foodOrderCommandService.markAsReadyToDelivery(command.orderId)
    }
    override fun getCommandClass() =  MarkOrderAsReadyToDeliveryCommand::class
}