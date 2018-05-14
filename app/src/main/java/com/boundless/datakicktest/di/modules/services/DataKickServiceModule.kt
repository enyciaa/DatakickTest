package com.boundless.datakicktest.di.modules.services

import com.boundless.datakicktest.common.services.datakick.DataKickApi
import com.boundless.datakicktest.common.services.datakick.DataKickService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
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
  fun provideDataKickServiceBaseUrl() = DATA_KICK_SERVICE_NAMED_BASE_URL

  @Provides
  fun provideElevationApi(
      @Named(DATA_KICK_SERVICE_NAMED_BASE_URL) baseUrl: String,
      jsonConverter: MoshiConverterFactory,
      callAdapter: RxJava2CallAdapterFactory
  ): DataKickApi {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverter)
        .addCallAdapterFactory(callAdapter)
        .build()

    return retrofit.create(DataKickApi::class.java)
  }

}
