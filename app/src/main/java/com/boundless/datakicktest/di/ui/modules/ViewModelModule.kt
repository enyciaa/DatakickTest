package com.boundless.datakicktest.di.ui.modules

import com.boundless.datakicktest.common.CoroutineCtxProvider
import com.boundless.datakicktest.common.ErrorLogger
import com.boundless.datakicktest.common.usecases.ProductFetcher
import com.boundless.datakicktest.common.ui.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideMainViewModel(
            productFetcher: ProductFetcher,
            coroutineCtxProvider: CoroutineCtxProvider
    ): MainViewModel =
            MainViewModel(coroutineCtxProvider, productFetcher)
}
