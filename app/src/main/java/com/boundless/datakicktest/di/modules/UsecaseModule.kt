package com.boundless.datakicktest.di.modules

import com.boundless.datakicktest.common.repositories.ProductsRepository
import com.boundless.datakicktest.common.usecases.ProductFetcher
import dagger.Module
import dagger.Provides

@Module
class UsecaseModule {

    @Provides
    fun productFetcher(
            productsRepository: ProductsRepository
    ): ProductFetcher =
            ProductFetcher(productsRepository)
}
