package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.ui.states.ViewState
import kotlinx.coroutines.experimental.*

abstract class MotherViewModel<T : ViewState> : LifecycleReceiver {

    var viewStateUpdatedCallback: ((T) -> Unit)? = null
    protected val coreroutineManager = Job()
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
}
