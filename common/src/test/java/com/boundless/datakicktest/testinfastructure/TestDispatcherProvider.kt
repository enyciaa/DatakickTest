package com.boundless.datakicktest.testinfastructure

import com.boundless.datakicktest.common.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class TestDispatcherProvider : DispatcherProvider {

    override val main: CoroutineDispatcher
        get() = Dispatchers.Unconfined

    override val background: CoroutineDispatcher
        get() = Dispatchers.Unconfined

}
