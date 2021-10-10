package com.paperlark.projector.syntax

import com.paperlark.projector.entities.DockerContainer
import com.paperlark.projector.entities.Instance
import com.paperlark.projector.entities.InstanceGroup
import com.paperlark.projector.providers.DockerContainerProvider
import com.paperlark.projector.providers.InstanceProvider
import kotlinx.coroutines.runBlocking

fun instanceGroup(name: String, f: InstanceGroupContext.() -> Unit): InstanceGroup<Instance> {
    val group = InstanceGroup<Instance>(name)
    val ctx = InstanceGroupContext(group)
    ctx.f()
    return group
}

fun containerGroup(name: String, f: ContainerGroupContext.() -> Unit): InstanceGroup<DockerContainer> {
    val group = InstanceGroup<DockerContainer>(name)
    val ctx = ContainerGroupContext(group)
    ctx.f()
    return group
}

class InstanceGroupContext(private val group: InstanceGroup<Instance>) {
    fun instance(host: String): Instance {
        val i = InstanceProvider.provide(host)
        group.add(i)
        return i
    }
}

class ContainerGroupContext(private val group: InstanceGroup<DockerContainer>) {
    fun dockerContainer(name: String): DockerContainer = runBlocking {
        val i = DockerContainerProvider.provide(name)
        group.add(i)
        i
    }
}
