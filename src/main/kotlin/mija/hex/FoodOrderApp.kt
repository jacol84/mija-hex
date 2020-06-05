package mija.hex

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component

@SpringBootApplication
class FoodOrderApp

fun main(args: Array<String>) {
    runApplication<FoodOrderApp>(*args)
}


@Component
class BeanInfo : CommandLineRunner {
    val logger: Logger = LoggerFactory.getLogger(BeanInfo::class.java)

    @Autowired
    lateinit var applicationContext: ApplicationContext


    override fun run(vararg args: String?) {
        logger.info("Beans")
        applicationContext.beanDefinitionNames.forEach { logger.info(it) }
    }
}
