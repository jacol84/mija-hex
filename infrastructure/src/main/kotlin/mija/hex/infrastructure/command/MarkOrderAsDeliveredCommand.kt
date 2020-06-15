package mija.hex.infrastructure.command

data class MarkOrderAsDeliveredCommand(override val orderId: Int):Command

