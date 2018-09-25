package com.boundless.datakicktest

import android.util.Log
import com.boundless.datakicktest.common.CoreroutineContextProvider
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.CoroutineExceptionHandler
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

class CoreroutineContextProviderImpl : CoreroutineContextProvider {

  override val androidUi: CoroutineContext
    get() = Android + exceptionHandler

  override val trampoline: CoroutineContext
    get() = EmptyCoroutineContext + exceptionHandler

  override val commonPool: CoroutineContext
    get() = CommonPool + exceptionHandler

  private val exceptionHandler: CoroutineContext = CoroutineExceptionHandler { _, throwable ->
    throw Throwable(throwable.message, throwable)
  }

}
