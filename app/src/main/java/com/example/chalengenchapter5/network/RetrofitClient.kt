package com.example.chalengenchapter5.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
        const val BASE_URL = "https://6331b372cff0e7bf70f492a8.mockapi.io/"

        val instance : RetrofitService by lazy{
            val service = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            service.create(RetrofitService::class.java)
        }
    }


