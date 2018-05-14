package com.boundless.datakicktest.common

import com.boundless.datakicktest.common.services.datakick.entities.RawDataKickResponse

class RawDataKickResponseBuilder {

  fun build() = RawDataKickResponse()
}

fun aRawDataKickResponseBuilder() = RawDataKickResponseBuilder()