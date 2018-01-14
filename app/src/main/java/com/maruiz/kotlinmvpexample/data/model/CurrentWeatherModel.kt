package com.maruiz.kotlinmvpexample.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Miguel Angel Ruiz
 */

class CurrentWeatherModel(val coord: Coord = Coord(), val weather: List<Weather> = emptyList(),
                          val base: String = "", val main: Main = Main(), val wind: Wind = Wind(),
                          var clouds: Clouds = Clouds(), val dt: Int = 0, val sys: Sys = Sys(),
                          val id: Int = 0, val name: String = "", val cod: Int = 0, val visivility: Int = 0)

class Clouds(val all: Int = 0)

class Coord(val lon: Double = 0.0, var lat: Double = 0.0)

class Main(val temp: Float = 0f, val pressure: Int = 0, val humidity: Int = 0,
           @SerializedName("temp_min") val tempMin: Float = 0f,
           @SerializedName("temp_max") val tempMax: Float = 0f)

class Sys(val type: Int = 0, val id: Int = 0, val message: Double = 0.0, val country: String = "",
          val sunrise: Int = 0, val sunset: Int = 0)

class Weather(val id: Int = 0, val main: String = "", val description: String = "", val icon: String = "")

class Wind(val speed: Double = 0.0, val deg: Int = 0)
