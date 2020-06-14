package mija.hex.infrastructure.command

import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
import mija.hex.infrastructure.CommandHandler
import org.springframework.context.annotation.Configuration

data class MarkOrderAsReadyToDeliveryCommand(override val orderId: Int):Command

@Configuration
class MarkOrderAsReadyToDeliveryCommandHandler(private val foodOrderCommandService: FoodOrderCommandService) : CommandHandler<MarkOrderAsReadyToDeliveryCommand> {
    override fun handle(command: Command) {
        foodOrderCommandService.markAsReadyToDelivery(command.orderId)
    }
    override fun getCommandClass() =  MarkOrderAsReadyToDeliveryCommand::class
}