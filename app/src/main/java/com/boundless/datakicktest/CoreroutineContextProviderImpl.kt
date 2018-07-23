package com.boundless.datakicktest

import com.boundless.datakicktest.common.CoreroutineContextProvider
import kotlinx.coroutines.experimental.CommonPool
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

class CoreroutineContextProviderImpl : CoreroutineContextProvider {

  override val androidUi: CoroutineContext
    get() = Android

  override val trampoline: CoroutineContext
    get() = EmptyCoroutineContext

  override val commonPool: CoroutineContext
    get() = CommonPool

}
