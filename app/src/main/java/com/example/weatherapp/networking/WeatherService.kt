package com.example.weatherapp.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import com.google.gson.GsonBuilder

import com.google.gson.Gson




object WeatherService {

    private const val BASE_URL = "https://api.weatherapi.com/v1/"

    fun getInstance() : WeatherInstance {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(WeatherInstance::class.java)
    }

}