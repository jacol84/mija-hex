package mija.hex.infrastructure.app.restaurant;

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication(scanBasePackages = ["mija.hex"])
class RestaurantApp

fun main(args: Array<String>) {
    runApplication<RestaurantApp>(*args)
}

@RestController
class RestaurantController {
    @get:GetMapping("\${restaurant.url.appName}")
    val appName: ResponseEntity<String>
        get() = ResponseEntity.ok("RestaurantApp")
}