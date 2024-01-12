package com.app.core.base.models

/**
 * Sealed class for defining the result of an Api request
 */
sealed class ApiResponse<out T> {

    /**
     * Success case
     *
     * @param result result of the Api request
     */
    data class Success<T>(val result: T) : ApiResponse<T>()

    /**
     * Error case
     *
     * @param exception the Api request exception
     */
    data class Error(val exception: Exception) : ApiResponse<Nothing>()
}
