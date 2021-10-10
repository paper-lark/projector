package com.paperlark.projector.commands

import com.paperlark.projector.entities.GroupStore
import kotlinx.cli.Subcommand
import java.nio.file.Files
import java.nio.file.Paths
import javax.script.ScriptEngineManager

class SyncCommand : Subcommand("sync", "Sync instance groups") {
    // TODO: add logger

    override fun execute() {
        with(ScriptEngineManager().getEngineByExtension("kts")) {
            val scriptReader = Files.newBufferedReader(Paths.get("./settings.kts"))
            eval(scriptReader)
            println("Instance groups found: ${GroupStore.getGroups().size}")
            // TODO: store instance groups as a file tree (including node type)
        }
    }
}
