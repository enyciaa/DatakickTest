package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.ui.states.ViewState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class MotherViewModel<T : ViewState> : LifecycleReceiver {

  var viewStateUpdatedCallback: ((T) -> Unit)? = null
  protected abstract var lastViewState: T
  private var compositeDisposable: CompositeDisposable = CompositeDisposable()

  override fun onAttach() {
  }

  override fun onDetach() {
    viewStateUpdatedCallback = null
    compositeDisposable.clear()
  }

  protected fun addToDisposables(disposable: Disposable) {
    compositeDisposable.add(disposable)
  }

  protected fun emitViewState(newViewState: T) {
    lastViewState = newViewState
    viewStateUpdatedCallback?.invoke(newViewState)
  }
}
