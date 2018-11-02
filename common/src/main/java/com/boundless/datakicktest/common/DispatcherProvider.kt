package com.boundless.datakicktest.common

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {

    val main: CoroutineDispatcher

    val background: CoroutineDispatcher

}