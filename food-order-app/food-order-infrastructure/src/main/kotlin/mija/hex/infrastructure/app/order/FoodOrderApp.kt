package mija.hex.infrastructure.app.order

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication(scanBasePackages = ["mija.hex"])
class FoodOrderApp


fun main(args: Array<String>) {
    runApplication<FoodOrderApp>(*args)
}

@RestController
class FoodOrderController {
    @get:GetMapping("\${foodOrder.url.appName}")
    val appName: ResponseEntity<String>
        get() = ResponseEntity.ok("FoodOrderApp")
}