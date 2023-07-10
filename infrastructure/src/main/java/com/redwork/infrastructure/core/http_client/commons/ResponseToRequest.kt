package com.redwork.infrastructure.core.http_client.commons

import com.redwork.domain.core.Resource
import com.redwork.domain.core.UiText
import com.redwork.infrastructure.R.string.not_found_result
import com.redwork.infrastructure.R.string.there_is_not_network_connection
import com.redwork.infrastructure.R.string.unknow_message_server
import com.redwork.infrastructure.core.http_client.error.ConvertErrorBody
import com.redwork.infrastructure.core.http_client.error.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {

    inline fun <T, M> send(result: Response<T>, mapper: (T) -> M): Resource<M> {
        return try {
            if (result.isSuccessful) {
                result.body()?.let { body ->
                    Resource.Success(mapper(body))
                } ?: Resource.Failure(UiText.StringResource(not_found_result))
            } else {
                val httpError: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(UiText.DynamicString(httpError?.message ?: "Ups, ocurrió un error inesperado"))
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(UiText.StringResource(unknow_message_server))
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure(UiText.StringResource(there_is_not_network_connection))
        }
    }

}