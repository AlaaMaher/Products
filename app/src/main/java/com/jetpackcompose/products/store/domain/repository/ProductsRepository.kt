package com.jetpackcompose.products.store.domain.repository

import arrow.core.Either
import com.jetpackcompose.products.store.domain.model.NetworkError
import com.jetpackcompose.products.store.domain.model.Product

interface ProductsRepository {
    suspend fun getProducts(): Either<NetworkError, List<Product>>
}