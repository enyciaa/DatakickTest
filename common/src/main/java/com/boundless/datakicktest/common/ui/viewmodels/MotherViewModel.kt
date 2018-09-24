package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.ui.states.ViewState
import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext

abstract class MotherViewModel<T : ViewState> : LifecycleReceiver {

  val coreroutineManager = Job()
  var viewStateUpdatedCallback: ((T) -> Unit)? = null
  protected abstract var lastViewState: T

  override fun onAttach() {
  }

  override fun onDetach() {
    coreroutineManager.cancel()
    viewStateUpdatedCallback = null
  }

  protected fun emitViewState(newViewState: T) {
    lastViewState = newViewState
    viewStateUpdatedCallback?.invoke(newViewState)
  }

//  protected fun launchDefaultCoreroutine(block: suspend CoroutineScope.() -> Unit) {
//    launch(coreroutineContextProvider.commonPool, parent = coreroutineManager) { block() }
//  }
}
