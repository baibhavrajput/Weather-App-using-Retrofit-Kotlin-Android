package com.example.weatherapp.repo

import com.example.weatherapp.networking.WeatherInstance

class WeatherRepository(private val instance: WeatherInstance) {

   suspend fun getCurrentWeather(key : String ,query : String,days : Int) = instance.getCurrentTemp(key,query,days)

}