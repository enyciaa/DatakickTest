package com.boundless.datakicktest.common.services.api

import com.boundless.datakicktest.common.entities.AndroidStarter
import com.boundless.datakicktest.common.services.api.entities.RawResponse

fun RawResponse.mapToDomainValue(): AndroidStarter {
  return AndroidStarter(results.value)
}
