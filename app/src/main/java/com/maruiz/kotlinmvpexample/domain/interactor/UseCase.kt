package com.maruiz.kotlinmvpexample.domain.interactor

import dagger.internal.Preconditions
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<ReturnType, Param> {

    private var disposables: CompositeDisposable = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(params: Param): Single<ReturnType>

    open fun execute(observer: DisposableSingleObserver<ReturnType>, params: Param) {
        val single = this.buildUseCaseObservable(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        addDisposable(single.subscribeWith<DisposableSingleObserver<ReturnType>>(observer))
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        if (disposables.isDisposed) {
            disposables = CompositeDisposable()
        }
        disposables.add(disposable)
    }
}
