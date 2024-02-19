package com.jetpackcompose.products.store.presentation.util

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object EventBus {
    private val _events = Channel<Any>()
    val events = _events.receiveAsFlow()

    suspend fun sentEvents(event:Any){
        _events.send(event)
    }
}

sealed interface Event{
    data class Toast(val message:String):Event
}
