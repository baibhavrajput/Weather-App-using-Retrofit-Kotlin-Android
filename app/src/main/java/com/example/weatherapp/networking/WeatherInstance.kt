package com.example.weatherapp.networking


import com.example.weatherapp.modals.WeatherClass
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//const val API_KEY = "f5f79c7077e3422fb67153224210510"
interface WeatherInstance {

    @GET("forecast.json")
    suspend fun getCurrentTemp(@Query("key")key : String , @Query("q")query : String , @Query("days")days : Int) : Response<WeatherClass>

}

//api.openweathermap.org/data/2.5/forecast?q={city name}&appid={API key}

//http://api.openweathermap.org/data/2.5/weather?q=London&appid=04e626bec88ddefc3e6fd9eb22e329a2