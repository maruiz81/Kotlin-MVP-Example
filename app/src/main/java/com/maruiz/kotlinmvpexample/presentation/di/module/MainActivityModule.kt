package com.maruiz.kotlinmvpexample.presentation.di.module

import com.maruiz.kotlinmvpexample.data.api.services.CurrentWeatherService
import com.maruiz.kotlinmvpexample.domain.interactor.GetWeather
import com.maruiz.kotlinmvpexample.presentation.di.PerActivity
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author Miguel Angel Ruiz
 */
@Module
class MainActivityModule {
    @Provides
    @PerActivity
    fun provideFriendsService(retrofit: Retrofit) = retrofit.create(CurrentWeatherService::class.java)

    @Provides
    @PerActivity
    fun provideGetFriendsInteractor(currentWeatherService: CurrentWeatherService) = GetWeather(currentWeatherService)
}