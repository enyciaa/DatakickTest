package com.boundless.datakicktest.di.modules.services

import com.boundless.datakicktest.common.services.datakick.DATA_KICK_BASE_URL
import com.boundless.datakicktest.common.services.datakick.DataKickApi
import com.boundless.datakicktest.common.services.datakick.DataKickService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
class DataKickServiceModule {

  companion object {
    private const val DATA_KICK_SERVICE_NAMED_BASE_URL = "DATA_KICK_SERVICE_NAMED_BASE_URL"
  }

  @Provides
  fun provideDataKickService(dataKickApi: DataKickApi): DataKickService =
      DataKickService(dataKickApi)

  @Provides
  @Named(DATA_KICK_SERVICE_NAMED_BASE_URL)
  fun provideDataKickServiceBaseUrl() = DATA_KICK_BASE_URL

  @Provides
  fun provideDataKickApi(
      @Named(DATA_KICK_SERVICE_NAMED_BASE_URL) baseUrl: String,
      jsonConverter: MoshiConverterFactory,
      callAdapter: CoroutineCallAdapterFactory
  ): DataKickApi {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverter)
        .addCallAdapterFactory(callAdapter)
        .build()

    return retrofit.create(DataKickApi::class.java)
  }

}
