package com.example.saeqalfirdaus.ui.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object APIClient
{
    private const val BASE_URL = "http://10.251.60.246/program/html/android_backend/"

    val instace: APIServices by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(APIServices::class.java)

    }
}