package com.boundless.datakicktest.common.services.api

import com.boundless.datakicktest.common.entities.AndroidStarter
import com.boundless.risingtides.common.services.ElevationApi
import io.reactivex.Single

class Service(
    private val elevationApi: ElevationApi
) {

  fun fetchValue(param: String): Single<AndroidStarter> =
    elevationApi.fetchValue(param)
        .map { it.mapToDomainValue() }

}
