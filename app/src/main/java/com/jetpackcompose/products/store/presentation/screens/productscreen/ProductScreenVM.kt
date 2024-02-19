package com.jetpackcompose.products.store.presentation.screens.productscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpackcompose.products.store.domain.repository.ProductsRepository
import com.jetpackcompose.products.store.presentation.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductScreenVM @Inject constructor(
    private val productsRepository: ProductsRepository
) :ViewModel() {

    private val _productsState= MutableStateFlow(ProductsViewStates())
    val productsState =_productsState.asStateFlow()

    init {
        getProducts()
    }
    fun getProducts(){
        viewModelScope.launch {
            _productsState.update {
                it.copy(isLoading = true)
            }
            productsRepository.getProducts().onRight {
                products ->
                _productsState.update {
                    it.copy(products =products)
                }
            }.onLeft {
                error ->
                _productsState.update {
                    it.copy(error =error.error.message)
                }
                sentEvent(Event.Toast(error.error.message))
            }
            _productsState.update {
                it.copy(isLoading = false)
            }
        }
    }

}