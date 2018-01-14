package com.maruiz.kotlinmvpexample.presentation.presenter

import com.maruiz.kotlinmvpexample.data.model.CurrentWeatherModel
import com.maruiz.kotlinmvpexample.domain.interactor.GetWeather
import com.maruiz.kotlinmvpexample.presentation.view.activity.MainActivityView
import io.reactivex.observers.DisposableObserver

/**
 * @author Miguel Angel Ruiz
 */
class MainPresenter(private val getWeather: GetWeather) {

    private lateinit var view: MainActivityView

    fun bind(view: MainActivityView) {
        this.view = view
    }

    fun unBind() {
        getWeather.dispose()
    }

    fun takeWeather(city: String) {
        getWeather.execute(WeatherObserver(), GetWeather.Params(city))
    }

    private fun showWeatherData(currentWeatherModel: CurrentWeatherModel) {
        view.setCity(currentWeatherModel.name)
        view.setTemperature(Math.round(currentWeatherModel.main.temp))
        view.setMaxTemperature(Math.round(currentWeatherModel.main.tempMax))
        view.setMinTemperature(Math.round(currentWeatherModel.main.tempMin))
    }

    inner class WeatherObserver() : DisposableObserver<CurrentWeatherModel>() {
        override fun onError(e: Throwable) {
        }

        override fun onComplete() {
        }

        override fun onNext(weatherModel: CurrentWeatherModel) {
            this@MainPresenter.showWeatherData(weatherModel)
        }

    }
}
