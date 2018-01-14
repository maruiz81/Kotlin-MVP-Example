package com.maruiz.giftme.presentation.di.module.appscope

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Miguel Angel Ruiz
 */
@Singleton
@Module
internal class RetrofitModule {

    companion object {
        val REMOTE_SERVICE_URL = "http://api.openweathermap.org/data/2.5/"
    }

    @Singleton
    @Provides
    fun provideListenRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(REMOTE_SERVICE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}
