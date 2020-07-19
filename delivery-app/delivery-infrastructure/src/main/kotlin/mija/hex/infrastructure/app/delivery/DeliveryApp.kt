package mija.hex.infrastructure.app.delivery;

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication(scanBasePackages = ["mija.hex"])
class DeliveryApp

fun main(args: Array<String>) {
    runApplication<DeliveryApp>(*args)
}

@RestController
class DeliveryAppController {
    @get:GetMapping("\${delivery.url.appName}")
    val appName: ResponseEntity<String>
        get() = ResponseEntity.ok("DeliveryApp")
}