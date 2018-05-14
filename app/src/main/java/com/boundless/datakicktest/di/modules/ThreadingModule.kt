package com.boundless.datakicktest.di.modules

import com.boundless.datakicktest.ThreadProviderImpl
import com.boundless.elephant.libraryhelpers.dagger.PerApplication
import com.boundless.elephant.threading.ThreadProvider
import dagger.Module
import dagger.Provides

@Module
class ThreadingModule {

  @Provides
  @PerApplication
  fun provideThreading(): ThreadProvider =
      ThreadProviderImpl()
}