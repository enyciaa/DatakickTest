package com.boundless.datakicktest.common.services.datakick

import com.boundless.datakicktest.common.services.datakick.entities.RawDataKickResponse
import io.reactivex.Single
import retrofit2.http.GET

const val DATA_KICK_BASE_URL = "https://www.datakick.org/api/"

interface DataKickApi {

  @GET("items")
  fun fetchItems(): Single<List<RawDataKickResponse>>
}
