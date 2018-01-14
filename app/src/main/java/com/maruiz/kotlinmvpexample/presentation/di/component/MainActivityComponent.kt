package com.maruiz.kotlinmvpexample.presentation.di.component

import com.maruiz.kotlinmvpexample.presentation.di.PerActivity
import com.maruiz.kotlinmvpexample.presentation.di.module.MainActivityModule

import dagger.Component

/**
 * @author Miguel Angel Ruiz
 */
@PerActivity
@Component(dependencies = [AppComponent::class], modules = [(MainActivityModule::class)])
interface MainActivityComponent

