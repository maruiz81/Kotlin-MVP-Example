package com.maruiz.kotlinmvpexample.presentation.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Miguel Angel Ruiz
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {

}
