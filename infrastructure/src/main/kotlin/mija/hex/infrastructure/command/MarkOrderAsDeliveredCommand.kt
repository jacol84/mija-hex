package mija.hex.infrastructure.command

import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
import mija.hex.infrastructure.CommandHandler
import org.springframework.context.annotation.Configuration

data class MarkOrderAsDeliveredCommand(override val orderId: Int):Command

@Configuration
class MarkOrderAsDeliveredCommandHandler(private val foodOrderCommandService: FoodOrderCommandService) : CommandHandler<MarkOrderAsDeliveredCommand> {
    override fun handle(command: Command) {
        foodOrderCommandService.markAsDelivered(command.orderId)
    }
    override fun getCommandClass() =  MarkOrderAsDeliveredCommand::class
}