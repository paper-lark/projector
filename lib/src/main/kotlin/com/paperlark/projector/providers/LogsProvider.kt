package com.paperlark.projector.providers

import com.paperlark.projector.entities.DockerContainer
import com.paperlark.projector.utils.runCommandAsync
import kotlinx.coroutines.flow.Flow

object LogsProvider {
    fun provide(container: DockerContainer, n: Int? = null, shouldFollow: Boolean = false): Flow<String> {
        val cmd = "docker -n " + (n ?: "all") + " " + (if (shouldFollow) "--follow " else "") + container.containerId
        return runCommandAsync(cmd)
    }
}
