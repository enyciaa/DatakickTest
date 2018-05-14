package com.boundless.datakicktest.common.services.api.entities

import com.squareup.moshi.Json

data class RawResponse(
    @Json(name = "results")
    val results: Result
)
