package com.boundless.datakicktest.di.modules

import android.app.Application
import android.content.res.Resources
import dagger.Module
import dagger.Provides

@Module
class AndroidSystemModule {

  @Provides
  fun provideResources(application: Application): Resources =
      application.resources
}