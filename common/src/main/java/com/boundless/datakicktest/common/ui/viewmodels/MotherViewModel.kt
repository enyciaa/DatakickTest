package com.boundless.datakicktest.common.ui.viewmodels

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class MotherViewModel : LifecycleReceiver {

  private var compositeDisposable: CompositeDisposable = CompositeDisposable()

  override fun onAttach() {
  }

  override fun onDetach() {
    compositeDisposable.clear()
  }

  protected fun addToDisposables(disposable: Disposable) {
    compositeDisposable.add(disposable)
  }
}
