package com.maruiz.kotlinmvpexample.domain.interactor

import com.maruiz.kotlinmvpexample.data.api.services.CurrentWeatherService
import com.maruiz.kotlinmvpexample.data.model.CurrentWeatherModel

/**
 * @author Miguel Angel Ruiz
 */
class GetWeather(private val currentWeatherService: CurrentWeatherService) :
        UseCase<CurrentWeatherModel, GetWeather.Params>() {
    override fun buildUseCaseObservable(params: GetWeather.Params) =
            currentWeatherService.getCurrentWeather(params.city)

    class Params(val city: String)
}