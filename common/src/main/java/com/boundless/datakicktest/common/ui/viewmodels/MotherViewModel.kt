package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.ui.states.ViewState
import kotlinx.coroutines.experimental.*

abstract class MotherViewModel<T : ViewState>(
        private val coreroutineContextProvider: CoreroutineContextProvider
) : LifecycleReceiver {

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

    protected fun launchDefaultCoreRoutine(block: suspend CoroutineScope.() -> Unit) {
        launch(coreroutineContextProvider.commonPool, parent = coreroutineManager) { block() }
    }
}
