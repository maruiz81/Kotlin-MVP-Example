package com.maruiz.kotlinmvpexample.presentation.presenter

import com.maruiz.kotlinmvpexample.data.model.CurrentWeatherModel
import com.maruiz.kotlinmvpexample.domain.interactor.GetWeather
import com.maruiz.kotlinmvpexample.presentation.view.activity.MainActivity
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.observers.DisposableObserver
import io.reactivex.plugins.RxJavaPlugins
import org.junit.After
import org.junit.Before
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

    private lateinit var mainPresenter: MainPresenter

    @Mock
    private lateinit var mockGetWeather: GetWeather

    @Mock
    private lateinit var mockView: MainActivity

    @Captor
    private lateinit var getWeatherCaptor: ArgumentCaptor<DisposableObserver<CurrentWeatherModel>>

    private val immediateScheduler = object : Scheduler() {
        override fun createWorker() = ExecutorScheduler.ExecutorWorker(Executor { it.run() })
    }

    @Before
    fun setUp() {
        RxJavaPlugins.setInitIoSchedulerHandler { immediateScheduler }
        mainPresenter = MainPresenter(mockGetWeather)
    }

    @After
    fun tearDown() {
        RxJavaPlugins.reset()
        RxAndroidPlugins.reset()
    }
}