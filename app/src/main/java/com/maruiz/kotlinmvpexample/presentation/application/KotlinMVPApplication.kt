package com.maruiz.kotlinmvpexample.presentation.application

import android.app.Application
import com.maruiz.kotlinmvpexample.presentation.di.component.AppComponent
import com.maruiz.kotlinmvpexample.presentation.di.component.DaggerAppComponent

/**
 * @author Miguel Angel Ruiz
 */
class KotlinMVPApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector() {
        appComponent = DaggerAppComponent.builder().build()
    }
}
