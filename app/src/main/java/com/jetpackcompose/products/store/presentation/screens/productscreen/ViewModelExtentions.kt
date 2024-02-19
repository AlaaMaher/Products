package com.jetpackcompose.products.store.presentation.screens.productscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpackcompose.products.store.presentation.util.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sentEvent(event:Any){
    viewModelScope.launch {
        EventBus.sentEvents(event)
    }
}