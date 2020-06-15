package mija.hex.infrastructure.command

data class PrepareDishCommand(override val orderId: Int) : Command

