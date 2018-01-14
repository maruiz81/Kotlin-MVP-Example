package com.maruiz.kotlinmvpexample.presentation.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.maruiz.kotlinmvpexample.R
import com.maruiz.kotlinmvpexample.presentation.application.KotlinMVPApplication
import com.maruiz.kotlinmvpexample.presentation.di.component.DaggerMainActivityComponent
import com.maruiz.kotlinmvpexample.presentation.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

/**
 * @author Miguel Angel Ruiz
 */
class MainActivity : AppCompatActivity(), MainActivityView {

    private val TAG = "MainActivity"

    @Inject
    internal lateinit var presenter: MainPresenter

    override fun setCity(city: String) {
        location.text = city
    }

    override fun setWeatherCondition(weatherCondition: String) {
        weatherDescription.text = weatherCondition
    }

    override fun setTemperature(temperature: Int) {
        temp.text = getString(R.string.temperature, temperature)
    }

    override fun setMaxTemperature(maxTemperature: Int) {
        maxTemp.text = getString(R.string.max_temp, maxTemperature)
    }

    override fun setMinTemperature(minTemperature: Int) {
        minTemp.text = getString(R.string.min_temp, minTemperature)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeInjector()

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { presenter.takeWeather(LONDON) }
    }

    override fun onStart() {
        super.onStart()
        presenter.bind(this)
        presenter.takeWeather(LONDON)
    }

    override fun onStop() {
        super.onStop()
        presenter.unBind()
    }

    private fun initializeInjector() {
        DaggerMainActivityComponent.builder().appComponent((this.application as KotlinMVPApplication).appComponent)
                .build().inject(this)
    }

    companion object {

        private val LONDON = "London"
    }

}
