package com.maruiz.kotlinmvpexample.data.api.services

import com.maruiz.kotlinmvpexample.data.api.API_KEY
import com.maruiz.kotlinmvpexample.data.model.CurrentWeatherModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Miguel Angel Ruiz
 */
interface CurrentWeatherService {

    @GET("weather?units=metric&apikey=" + API_KEY)
    fun getCurrentWeather(@Query("q") city: String): Observable<CurrentWeatherModel>
}
