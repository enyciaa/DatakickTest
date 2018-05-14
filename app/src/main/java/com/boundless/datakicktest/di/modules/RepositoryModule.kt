package com.boundless.datakicktest.di.modules

import com.boundless.datakicktest.common.repositories.MyRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

  @Provides
  fun provideMyRepository(): MyRepository =
      MyRepository()
}