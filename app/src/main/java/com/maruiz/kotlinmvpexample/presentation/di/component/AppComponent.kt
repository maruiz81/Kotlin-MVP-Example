package com.maruiz.kotlinmvpexample.presentation.di.component

import com.maruiz.giftme.presentation.di.module.appscope.RetrofitModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Miguel Angel Ruiz
 */
@Singleton
@Component(modules = [(RetrofitModule::class)])
interface AppComponent {
    fun provideListenRetrofit(): Retrofit
}
