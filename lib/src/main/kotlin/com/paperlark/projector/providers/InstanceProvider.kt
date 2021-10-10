package com.paperlark.projector.providers

import com.paperlark.projector.entities.Instance

object InstanceProvider {
    fun provide(host: String): Instance = Instance(host)
}
