package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.ui.states.ViewState

abstract class MotherViewModel<T : ViewState> : LifecycleReceiver {

  var viewStateUpdatedCallback: ((T) -> Unit)? = null
  protected abstract var lastViewState: T

  override fun onAttach() {
  }

  override fun onDetach() {
    viewStateUpdatedCallback = null
  }

  protected fun emitViewState(newViewState: T) {
    lastViewState = newViewState
    viewStateUpdatedCallback?.invoke(newViewState)
  }
}
