package com.maruiz.kotlinmvpexample.presentation.view.activity

/**
 * @author Miguel Angel Ruiz
 */
interface MainActivityView {
    fun setCity(city: String)
    fun setWeatherCondition(weatherCondition: String)
    fun setTemperature(temperature: Int)
    fun setMinTemperature(minTemperature: Int)
    fun setMaxTemperature(maxTemperature: Int)
    fun showError()
}
