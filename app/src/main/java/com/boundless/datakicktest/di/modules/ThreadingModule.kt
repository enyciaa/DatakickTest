package com.boundless.datakicktest.di.modules

import com.boundless.datakicktest.CoreroutineContextProviderImpl
import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.aardvark.libraryhelpers.dagger.PerApplication
import dagger.Module
import dagger.Provides

@Module
class ThreadingModule {

  @Provides
  @PerApplication
  fun provideCoreroutineContext(): CoreroutineContextProvider =
      CoreroutineContextProviderImpl()
}