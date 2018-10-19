package com.boundless.datakicktest.testinfastructure

import com.boundless.datakicktest.common.CoroutineCtxProvider
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

class TestCoroutineCtxProvider : CoroutineCtxProvider {

  override val UI: CoroutineContext
    get() = EmptyCoroutineContext

  override val trampoline: CoroutineContext
    get() = EmptyCoroutineContext

  override val commonPool: CoroutineContext
    get() = EmptyCoroutineContext

}
