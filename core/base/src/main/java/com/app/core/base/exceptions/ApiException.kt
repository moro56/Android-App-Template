package com.app.core.base.exceptions

/**
 * Different types of Api exception
 */
sealed class ApiException : Exception() {

    /**
     * Exception that has a reason defined
     *
     * @param reason reason of the exception
     */
    data class ReasonException(val reason: String) : ApiException()

    /**
     * Exception that has a error status code defined
     *
     * @param statusCode error status code of the exception
     * @param reason reason of the exception
     */
    data class StatusCodeException(val statusCode: Int, val reason: String) : ApiException()

    /**
     * Network exception
     */
    data object NetworkException : ApiException()

    /**
     * Generic exception
     *
     * @param errorMessage error message
     */
    data class GenericException(val errorMessage: String) : ApiException()
}
