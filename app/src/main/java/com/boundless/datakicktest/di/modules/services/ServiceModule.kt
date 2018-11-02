package com.boundless.datakicktest.di.modules.services

import dagger.Module
import dagger.Provides
import retrofit2.converter.moshi.MoshiConverterFactory

@Module(
        includes = [
            DataKickServiceModule::class
        ]
)
class ServiceModule {

    @Provides
    fun provideRetrofitConverterFactory(): MoshiConverterFactory =
            MoshiConverterFactory.create()
}
