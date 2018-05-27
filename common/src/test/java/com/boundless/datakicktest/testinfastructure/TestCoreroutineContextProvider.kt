package com.boundless.datakicktest.testinfastructure

import com.boundless.datakicktest.common.CoreroutineContextProvider
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

class TestCoreroutineContextProvider : CoreroutineContextProvider {

  override val androidUi: CoroutineContext
    get() = EmptyCoroutineContext

  override val trampoline: CoroutineContext
    get() = EmptyCoroutineContext

  override val commonPool: CoroutineContext
    get() = EmptyCoroutineContext

}
