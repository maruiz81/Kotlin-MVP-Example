package com.maruiz.kotlinmvpexample.presentation.presenter

import com.maruiz.kotlinmvpexample.data.model.CurrentWeatherModel
import com.maruiz.kotlinmvpexample.data.model.Main
import com.maruiz.kotlinmvpexample.domain.interactor.GetWeather
import com.maruiz.kotlinmvpexample.presentation.view.activity.MainActivity
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.capture
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.plugins.RxJavaPlugins
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executor

/**
 * @author Miguel Angel Ruiz
 */
@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    private val CITY = "LONDON"

    private lateinit var mainPresenter: MainPresenter

    @Mock
    private lateinit var mockGetWeather: GetWeather

    @Mock
    private lateinit var mockView: MainActivity

    @Captor
    private lateinit var getWeatherCaptor: ArgumentCaptor<DisposableSingleObserver<CurrentWeatherModel>>

    private val immediateScheduler = object : Scheduler() {
        override fun createWorker() = ExecutorScheduler.ExecutorWorker(Executor { it.run() })
    }

    @Before
    fun setUp() {
        RxJavaPlugins.setInitIoSchedulerHandler { immediateScheduler }
        mainPresenter = MainPresenter(mockGetWeather)

        mainPresenter.bind(mockView)
        mainPresenter.takeWeather(CITY)

        verify(mockGetWeather).execute(capture(getWeatherCaptor), any())
    }

    @Test
    fun testShowingDataSuccessfully() {
        val weather = CurrentWeatherModel(name = CITY, main = Main(temp = 5f, tempMin = 3f, tempMax = 15f))
        getWeatherCaptor.value.onSuccess(weather)
        verify(mockView).setCity(weather.name)
        verify(mockView).setTemperature(Math.round(weather.main.temp))
        verify(mockView).setMinTemperature(Math.round(weather.main.tempMin))
        verify(mockView).setMaxTemperature(Math.round(weather.main.tempMax))
    }

    @Test
    fun testShowingDataFailed() {
        getWeatherCaptor.value.onError(Exception())
        verify(mockView).showError()
    }

    @After
    fun tearDown() {
        RxJavaPlugins.reset()
        RxAndroidPlugins.reset()
    }
}