package mija.hex.infrastructure

import mija.hex.infrastructure.command.Command
import kotlin.reflect.KClass

interface CommandHandler<T : Command> {
    fun handle(command: Command)
    fun getCommandClass(): KClass<T>

}
