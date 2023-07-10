package com.redwork.infrastructure.core.http_client

import com.redwork.infrastructure.auth.repository.contracts.AuthTemporalRepository
import com.redwork.infrastructure.core.http_client.commons.Config.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideOkHttpClient(datastore: AuthTemporalRepository) = OkHttpClient.Builder().addInterceptor {
        val token = runBlocking {
            datastore.getSessionData().first().token
        }

        val newRequest = it.request().newBuilder().addHeader("Authorization", token ?: "").build()
        it.proceed(newRequest)
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}