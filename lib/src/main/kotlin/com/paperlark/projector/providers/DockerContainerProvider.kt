package com.paperlark.projector.providers

import com.paperlark.projector.entities.DockerContainer
import com.paperlark.projector.utils.runCommand

object DockerContainerProvider {
    suspend fun provide(containerName: String): DockerContainer {
        val id = runCommand("docker ps --filter name=$containerName --format {{.ID}}")
        if (id.isEmpty()) {
            throw RuntimeException("container name=$containerName not found")
        }
        return DockerContainer(id)
    }
}
