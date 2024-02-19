package com.jetpackcompose.products.store.domain.model

data class NetworkError(
    val error: ApiError,
    val t: Throwable? = null
)

enum class ApiError(val message: String) {
    NETWORK_ERROR("Network Error"),
    UNKNOWN_RESPONSE("Unknown Response"),
    UNKNOWN_ERROR("Unknown Error")
}
