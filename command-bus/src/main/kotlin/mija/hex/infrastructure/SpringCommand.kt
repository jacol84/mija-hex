package mija.hex.infrastructure

import mija.hex.infrastructure.command.Command
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

private val logger: Logger = LoggerFactory.getLogger(SpringCommand::class.java)

@Service
internal class SpringCommand(private val applicationEventPublisher: ApplicationEventPublisher, private val applicationContext: ApplicationContext) : CommandBus {

    private val map by lazy {
        logger.info("lazy init map")
        applicationContext.getBeanNamesForType(CommandHandler::class.java)
                .map { applicationContext.getBean(it, CommandHandler::class.java) }.groupBy { it.getCommandClass() }
    }

    override fun fire(command: Command) {
        logger.info("before fire command: $command")
        applicationEventPublisher.publishEvent(command)
        logger.info("after fire command: $command")
    }

    @EventListener
    override fun handle(command: Command) {
        logger.info("before handler command: $command")
        map[command::class]?.forEach { it.handle(command) }
        logger.info("after handler command: $command")
    }
}