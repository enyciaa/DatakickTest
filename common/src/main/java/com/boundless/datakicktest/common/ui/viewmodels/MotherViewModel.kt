package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.DispatcherProvider
import com.boundless.datakicktest.common.ui.states.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

abstract class MotherViewModel<T : ViewState>(
        dispatcherProvider: DispatcherProvider
) : LifecycleReceiver {

    var viewStateUpdatedCallback: ((T) -> Unit)? = null
    protected val coreroutineSupervisor = SupervisorJob()
    protected val coroutineScope: CoroutineScope = CoroutineScope(dispatcherProvider.main + coreroutineSupervisor)
    protected abstract var lastViewState: T

    override fun onAttach() {
    }

    override fun onDetach() {
        coreroutineSupervisor.cancel()
        viewStateUpdatedCallback = null
    }

    protected fun emitViewState(newViewState: T) {
        lastViewState = newViewState
        viewStateUpdatedCallback?.invoke(newViewState)
    }
}
