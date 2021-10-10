package com.paperlark.projector.entities

import org.jetbrains.kotlin.backend.common.push

class InstanceGroup<T : AbstractInstance>(val name: String) {
    internal val entities = mutableListOf<T>()

    init {
        GroupStore.register(this)
    }

    fun add(entity: T) = entities.push(entity)
}
