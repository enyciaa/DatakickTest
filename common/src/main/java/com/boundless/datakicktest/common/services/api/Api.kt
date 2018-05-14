package com.boundless.risingtides.common.services

import com.boundless.datakicktest.common.services.api.entities.RawResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

const val ELEVATION_BASE_URL = "ELEVATION_BASE_URL"

interface ElevationApi {

  @GET("path/path")
  fun fetchValue(
      @Query("query_param") param: String
  ): Single<RawResponse>
}
