package com.example.privatellmchat.di


import com.example.privatellmchat.data.api.AuthentificationApi
import com.example.privatellmchat.data.api.ChatApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.google.gson.GsonBuilder

object NetworkModule {
    private const val BASE_URL = "https://8127273d-7276-4279-b348-106c90a02f33.us-east-1.cloud.genez.io"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val gson = GsonBuilder()
    .setLenient()
    .create();

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val chatApi: ChatApi = retrofit.create(ChatApi::class.java)
    val authApi: AuthentificationApi = retrofit.create(AuthentificationApi::class.java)
} 