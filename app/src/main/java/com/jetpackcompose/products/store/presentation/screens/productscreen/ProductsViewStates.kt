package com.jetpackcompose.products.store.presentation.screens.productscreen

import com.jetpackcompose.products.store.domain.model.Product

data class ProductsViewStates(
    val isLoading:Boolean =false,
    val products: List<Product> = emptyList(),
    val error:String?=null

    )
