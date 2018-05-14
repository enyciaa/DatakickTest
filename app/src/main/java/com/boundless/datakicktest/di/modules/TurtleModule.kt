package com.boundless.datakicktest.di.modules

import android.content.res.Resources
import com.boundless.turtle.providers.ResourceProvider
import com.boundless.turtle.providers.ResourceProviderImpl
import dagger.Module
import dagger.Provides

@Module
class TurtleModule {

  @Provides
  fun provideResourceProvider(resources: Resources): ResourceProvider =
      ResourceProviderImpl(resources)
}