package com.boundless.datakicktest.common.services.api.entities

import com.squareup.moshi.Json

data class Result(
    @Json(name = "value")
    val value: String = "hello"
)
