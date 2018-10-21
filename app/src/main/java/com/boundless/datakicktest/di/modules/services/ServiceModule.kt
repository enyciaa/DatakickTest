package com.boundless.datakicktest.di.modules.services

import com.boundless.datakicktest.di.modules.services.DataKickServiceModule
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
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

    @Provides
    fun provideCoreroutineCallAdapter(): CoroutineCallAdapterFactory =
            CoroutineCallAdapterFactory()
}
