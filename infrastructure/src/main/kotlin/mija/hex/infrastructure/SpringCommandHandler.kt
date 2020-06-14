//package mija.hex.infrastructure
//
//import mija.hex.domain.delivery.port.primary.DeliveryCommandService
//import mija.hex.domain.order.infrastructure.port.primary.FoodOrderCommandService
//import mija.hex.domain.restaurant.port.primary.CookCommandService
//import mija.hex.infrastructure.command.*
//import org.springframework.stereotype.Component
//
//@Component
//class SpringCommandHandler(private val foodOrderCommandService: FoodOrderCommandService,
//                           private val deliveryCommandService: DeliveryCommandService,
//                           private val cookCommandService: CookCommandService) : CommandHandler<Command> {
//
//    override fun handle(command: Command) {
//        when (command) {
//            is DeliverOrderCommand -> deliveryCommandService.deliverOrder(command.orderId)
//            is MarkOrderAsDeliveredCommand -> foodOrderCommandService.markAsDelivered(command.orderId)
//            is MarkOrderAsReadyToDeliveryCommand -> foodOrderCommandService.markAsReadyToDelivery(command.orderId)
//            is PrepareDishCommand -> cookCommandService.prepareOrder(command.orderId)
//            else -> throw IllegalArgumentException("Unsupported command {$command}")
//        }
//    }
//}