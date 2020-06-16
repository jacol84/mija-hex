package mija.hex.infrastructure

import mija.hex.infrastructure.command.Command

interface CommandBus {
    fun fire(command: Command)
    fun handle(command: Command)
}