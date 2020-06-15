package mija.hex.domain.restaurant.infrastructure.adapter.config

import mija.hex.domain.restaurant.port.primary.CookCommandService
import mija.hex.infrastructure.CommandHandler
import mija.hex.infrastructure.command.Command
import mija.hex.infrastructure.command.PrepareDishCommand
import org.springframework.context.annotation.Configuration

@Configuration
internal class PrepareDishCommandHandler(private val cookCommandService: CookCommandService) : CommandHandler<PrepareDishCommand> {
    override fun handle(command: Command) {
        cookCommandService.prepareOrder(command.orderId)
    }

    override fun getCommandClass() = PrepareDishCommand::class

}