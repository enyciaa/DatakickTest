package com.boundless.datakicktest

import android.util.Log
import com.boundless.datakicktest.common.ErrorLogger

class ErrorLoggerImpl : ErrorLogger {

    override fun i(
            message: String,
            tag: String
    ) {
        Log.i(tag, message)
    }

}