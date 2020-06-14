package mija.hex.infrastructure

import mija.hex.infrastructure.command.Command
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

private val logger: Logger = LoggerFactory.getLogger(SpringCommandBus::class.java)

@Service
internal class SpringCommandBus(private val applicationEventPublisher: ApplicationEventPublisher) : CommandBus {
    override fun fire(command: Command) {
        logger.info("fire command: $command")
        applicationEventPublisher.publishEvent(command)
    }

}