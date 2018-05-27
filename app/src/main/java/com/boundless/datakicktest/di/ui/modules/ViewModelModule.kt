package com.boundless.datakicktest.di.ui.modules

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.ui.model.MainModel
import com.boundless.datakicktest.common.ui.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

  @Provides
  fun provideMainViewModel(
      mainModel: MainModel,
      coreroutineContextProvider: CoreroutineContextProvider
  ): MainViewModel =
      MainViewModel(mainModel, coreroutineContextProvider)
}
