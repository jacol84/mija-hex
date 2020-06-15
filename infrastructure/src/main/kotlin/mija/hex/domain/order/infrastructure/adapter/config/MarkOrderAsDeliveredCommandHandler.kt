package mija.hex.domain.order.infrastructure.adapter.config

import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
import mija.hex.infrastructure.CommandHandler
import mija.hex.infrastructure.command.Command
import mija.hex.infrastructure.command.MarkOrderAsDeliveredCommand
import org.springframework.context.annotation.Configuration

@Configuration
internal class MarkOrderAsDeliveredCommandHandler(private val foodOrderCommandService: FoodOrderCommandService) : CommandHandler<MarkOrderAsDeliveredCommand> {
    override fun handle(command: Command) {
        foodOrderCommandService.markAsDelivered(command.orderId)
    }
    override fun getCommandClass() =  MarkOrderAsDeliveredCommand::class
}