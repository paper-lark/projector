package com.paperlark.projector

import com.paperlark.projector.commands.SyncCommand
import kotlinx.cli.ArgParser

fun main(args: Array<String>) {
    val parser = ArgParser("projector")
    val sync = SyncCommand()
    parser.subcommands(sync)
    // TODO: add logs command

    parser.parse(args)
}
