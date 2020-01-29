package com.example.androidwithkotlin.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService {
    companion object{
        fun create(): APIServiceInterface{
            val baseURL = "https://reqres.in/"
            val retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(APIServiceInterface::class.java)
        }
    }
}