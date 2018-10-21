package com.boundless.datakicktest

import android.os.Handler
import android.os.Looper
import kotlin.coroutines.experimental.Continuation

/**
 * Android Continuation, guarantees that, when resumed, is on the UI Thread
 */
class AndroidContinuation<T>(val continuation: Continuation<T>) : Continuation<T> by continuation {

    override fun resume(value: T) {
        if (Looper.myLooper() == Looper.getMainLooper()) continuation.resume(value)
        else Handler(Looper.getMainLooper()).post { continuation.resume(value) }
    }

    override fun resumeWithException(exception: Throwable) {
        if (Looper.myLooper() == Looper.getMainLooper()) continuation.resumeWithException(exception)
        else Handler(Looper.getMainLooper()).post { continuation.resumeWithException(exception) }
    }
}
