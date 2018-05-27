package com.boundless.datakicktest.di.ui.modules

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.repositories.ProductsRepository
import com.boundless.datakicktest.common.ui.model.MainModel
import dagger.Module
import dagger.Provides

@Module
class ModelModule {

  @Provides
  fun provideMainModel(
      coreroutineContextProvider: CoreroutineContextProvider,
      productsRepository: ProductsRepository
  ): MainModel =
      MainModel(coreroutineContextProvider, productsRepository)
}
