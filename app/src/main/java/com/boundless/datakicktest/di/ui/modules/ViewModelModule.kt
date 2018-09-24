package com.boundless.datakicktest.di.ui.modules

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.usecases.ProductFetcher
import com.boundless.datakicktest.common.ui.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

  @Provides
  fun provideMainViewModel(
          productFetcher: ProductFetcher,
          coreroutineContextProvider: CoreroutineContextProvider
  ): MainViewModel =
      MainViewModel(coreroutineContextProvider, productFetcher)
}
