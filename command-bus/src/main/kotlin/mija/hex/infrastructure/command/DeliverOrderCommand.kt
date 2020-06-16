package mija.hex.infrastructure.command

data class DeliverOrderCommand(override val orderId: Int) : Command

