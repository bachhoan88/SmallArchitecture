package com.example.mvvm.base

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    public override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
