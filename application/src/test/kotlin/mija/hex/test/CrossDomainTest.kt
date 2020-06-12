package mija.hex.test

import mija.hex.FoodOrderApp
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest(classes = [FoodOrderApp::class])
class CrossDomainTest {
    @Autowired
    lateinit var applicationContext: ApplicationContext

    @Test
    fun crossDomain() {

    }
}