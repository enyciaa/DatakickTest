package com.boundless.datakicktest.di.ui.modules

import com.boundless.datakicktest.common.repositories.MyRepository
import com.boundless.datakicktest.common.ui.model.MainModel
import com.boundless.elephant.threading.ThreadProvider
import dagger.Module
import dagger.Provides

@Module
class ModelModule {

  @Provides
  fun provideMainModel(
      threadProvider: ThreadProvider,
      myRepository: MyRepository
  ): MainModel =
      MainModel(threadProvider, myRepository)
}
