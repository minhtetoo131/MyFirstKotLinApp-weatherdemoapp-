package com.minhtetoo.myfirstkotlinapp.data.vos

data class ForecastList(val city: String, val country: String,
                        val dailyForecast:List<Forecast>)