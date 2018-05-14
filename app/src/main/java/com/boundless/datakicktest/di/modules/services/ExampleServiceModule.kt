package com.boundless.datakicktest.di.modules.services

import com.boundless.datakicktest.common.services.api.Service
import com.boundless.risingtides.common.services.ELEVATION_BASE_URL
import com.boundless.risingtides.common.services.ElevationApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
class ExampleServiceModule {

  companion object {
    private const val ELEVATION_SERVICE_NAMED_BASE_URL = "ELEVATION_SERVICE_NAMED_BASE_URL"
  }

  @Provides
  fun provideElevationService(elevationApi: ElevationApi): Service =
      Service(elevationApi)

  @Provides
  @Named(ELEVATION_SERVICE_NAMED_BASE_URL)
  fun provideElevationServiceBaseUrl() = ELEVATION_BASE_URL

  @Provides
  fun provideElevationApi(
      @Named(ELEVATION_SERVICE_NAMED_BASE_URL) baseUrl: String,
      jsonConverter: MoshiConverterFactory,
      callAdapter: RxJava2CallAdapterFactory
  ): ElevationApi {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverter)
        .addCallAdapterFactory(callAdapter)
        .build()

    return retrofit.create(ElevationApi::class.java)
  }

}
