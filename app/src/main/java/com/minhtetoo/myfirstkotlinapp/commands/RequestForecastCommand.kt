package com.minhtetoo.myfirstkotlinapp.commands

import com.minhtetoo.myfirstkotlinapp.ForecastDataMapper
import com.minhtetoo.myfirstkotlinapp.ForecastRequest
import com.minhtetoo.myfirstkotlinapp.data.vos.ForecastList

class RequestForecastCommand(val zipCode: String) :
        Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute())
    }
}