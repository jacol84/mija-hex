package mija.hex.infrastructure.command

import mija.hex.domain.restaurant.port.primary.CookCommandService
import mija.hex.infrastructure.CommandHandler
import org.springframework.context.annotation.Configuration

data class PrepareDishCommand(override val orderId: Int) : Command

@Configuration
class PrepareDishCommandHandler(private val cookCommandService: CookCommandService) : CommandHandler<PrepareDishCommand> {
    override fun handle(command: Command) {
        cookCommandService.prepareOrder(command.orderId)
    }

    override fun getCommandClass() = PrepareDishCommand::class

}