package com.boundless.datakicktest.di.modules

import android.content.res.Resources
import com.boundless.aardvark.platform.ResourceProviderImpl
import com.boundless.jerboa.platform.ResourceProvider
import dagger.Module
import dagger.Provides

@Module
class TurtleModule {

  @Provides
  fun provideResourceProvider(resources: Resources): ResourceProvider =
      ResourceProviderImpl(resources)
}