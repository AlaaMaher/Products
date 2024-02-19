package com.jetpackcompose.products.store.data.mapper

import com.jetpackcompose.products.store.domain.model.ApiError
import com.jetpackcompose.products.store.domain.model.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError {
    val error = when (this) {
        is IOException -> ApiError.NETWORK_ERROR
        is HttpException -> ApiError.UNKNOWN_RESPONSE
        else -> ApiError.UNKNOWN_ERROR
    }
    return NetworkError(error = error, t = this)
}