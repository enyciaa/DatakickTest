package com.boundless.risingtides.di.modules.services

import com.boundless.datakicktest.di.modules.services.ExampleServiceModule
import dagger.Module
import dagger.Provides
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module(
    includes = [
      ExampleServiceModule::class
    ]
)
class ServiceModule {

  @Provides
  fun provideRetrofitConverterFactory(): MoshiConverterFactory =
      MoshiConverterFactory.create()

  @Provides
  fun provideRxJava2CallAdapter(): RxJava2CallAdapterFactory =
      RxJava2CallAdapterFactory.create()
}
