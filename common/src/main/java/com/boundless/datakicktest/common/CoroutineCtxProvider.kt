package com.boundless.datakicktest.common

import kotlin.coroutines.experimental.CoroutineContext

interface CoroutineCtxProvider {

    val UI: CoroutineContext

    val trampoline: CoroutineContext

    val commonPool: CoroutineContext

}