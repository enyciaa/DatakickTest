package com.boundless.datakicktest.common

import kotlin.coroutines.experimental.CoroutineContext

interface ErrorLogger {

  fun i(message: String, tag: String = "Tiny Terry")

}