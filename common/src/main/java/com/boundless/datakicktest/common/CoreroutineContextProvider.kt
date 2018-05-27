package com.boundless.datakicktest.common

import kotlin.coroutines.experimental.CoroutineContext

interface CoreroutineContextProvider {

  val androidUi: CoroutineContext

  val trampoline: CoroutineContext

  val commonPool: CoroutineContext

}