package mija.hex.domain.order.infrastructure.port.shared

enum class OrderState {
    NEW,
    SENT_TO_RESTAURANT,
    READY_TO_DELIVERY,
    DELIVERED
}