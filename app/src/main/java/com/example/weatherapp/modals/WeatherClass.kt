package com.example.weatherapp.modals

import retrofit2.http.Headers

data class WeatherClass(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)