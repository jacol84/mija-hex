package mija.hex.infrastructure.command

data class MarkOrderAsReadyToDeliveryCommand(override val orderId: Int):Command

