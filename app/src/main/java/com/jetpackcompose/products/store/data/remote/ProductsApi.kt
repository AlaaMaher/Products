package com.jetpackcompose.products.store.data.remote

import com.jetpackcompose.products.store.domain.model.Product
import retrofit2.http.GET

interface ProductsApi {

    @GET("products")
    suspend fun getProducts():List<Product>
}