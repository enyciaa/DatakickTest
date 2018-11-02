package com.boundless.datakicktest.di.modules

import com.boundless.datakicktest.DispatcherProviderImpl
import com.boundless.datakicktest.common.DispatcherProvider
import com.boundless.aardvark.libraryhelpers.dagger.PerApplication
import com.boundless.datakicktest.ErrorLoggerImpl
import com.boundless.datakicktest.common.ErrorLogger
import dagger.Module
import dagger.Provides

@Module
class PlatformModule {

    @Provides
    @PerApplication
    fun provideCoreroutineContext(): DispatcherProvider =
            DispatcherProviderImpl()

    @Provides
    @PerApplication
    fun provideErrorHandler(): ErrorLogger =
            ErrorLoggerImpl()
}