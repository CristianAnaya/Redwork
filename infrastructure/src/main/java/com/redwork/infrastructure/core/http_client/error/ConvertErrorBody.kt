package com.redwork.infrastructure.core.http_client.error

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import java.lang.Exception


object ConvertErrorBody {

    fun convert(errorBody: ResponseBody?): ErrorResponse? {
        return try {
            errorBody?.source().let {

                val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
                val moshiAdapter = moshi.adapter(ErrorResponse::class.java)
                it?.let { it1 -> moshiAdapter.fromJson(it1) }
            }
        } catch (e: Exception) {
            null
        }
    }
}