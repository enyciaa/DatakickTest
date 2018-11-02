package com.boundless.datakicktest

import com.boundless.datakicktest.common.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DispatcherProviderImpl : DispatcherProvider {

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val background: CoroutineDispatcher
        get() = Dispatchers.IO
}
