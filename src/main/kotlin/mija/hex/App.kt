package mija.hex

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class App {
    val greeting: String
        get() {
            return "Hello world."
        }
}

fun main(args: Array<String>) {
    runApplication<App>(*args)

}
