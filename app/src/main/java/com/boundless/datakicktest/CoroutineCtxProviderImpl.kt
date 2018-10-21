package com.boundless.datakicktest

import com.boundless.datakicktest.common.CoroutineCtxProvider
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.CoroutineExceptionHandler
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

class CoroutineCtxProviderImpl : CoroutineCtxProvider {

    override val UI: CoroutineContext
        get() = Android + exceptionHandler

    override val trampoline: CoroutineContext
        get() = EmptyCoroutineContext + exceptionHandler

    override val commonPool: CoroutineContext
        get() = CommonPool + exceptionHandler

    private val exceptionHandler: CoroutineContext = CoroutineExceptionHandler { _, throwable ->
        throw Throwable(throwable.message, throwable)
    }

}
