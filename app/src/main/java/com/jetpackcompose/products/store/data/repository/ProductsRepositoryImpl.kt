package com.jetpackcompose.products.store.data.repository

import arrow.core.Either
import com.jetpackcompose.products.store.data.mapper.toNetworkError
import com.jetpackcompose.products.store.data.remote.ProductsApi
import com.jetpackcompose.products.store.domain.model.NetworkError
import com.jetpackcompose.products.store.domain.model.Product
import com.jetpackcompose.products.store.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor (private val productsApi: ProductsApi) :
    ProductsRepository {
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productsApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }
}