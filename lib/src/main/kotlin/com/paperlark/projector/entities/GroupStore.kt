package com.paperlark.projector.entities

object GroupStore {
    private val groups = mutableSetOf<InstanceGroup<*>>()

    fun <T : AbstractInstance> register(group: InstanceGroup<T>) = groups.add(group)

    fun getGroups(): List<InstanceGroup<*>> = groups.toList()
}
