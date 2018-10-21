package com.boundless.datakicktest.di.modules

import com.boundless.datakicktest.common.repositories.ProductsRepository
import com.boundless.datakicktest.common.services.datakick.DataKickService
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideMyRepository(
            dataKickService: DataKickService
    ): ProductsRepository =
            ProductsRepository(dataKickService)
}