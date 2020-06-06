package mija.hex.domain.order.port.shared

enum class OrderState {
    NEW,
    SENT_TO_RESTAURANT,
    READY_TO_DELIVERY,
    DELIVERED
}