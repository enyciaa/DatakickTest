package com.boundless.datakicktest.testinfastructure

import com.boundless.datakicktest.common.services.datakick.entities.RawDataKickResponse

class RawDataKickResponseBuilder {

  companion object {
    val DEFAULT_ID = "id"
    val DEFAULT_NAME = "name"
  }

  private var id = DEFAULT_ID
  private var name = DEFAULT_NAME
  private var brandName: String? = null
  private var publisher: String? = null
  private var author: String? = null

  fun withBrandName(brandName: String) = this.apply {
    this.brandName = brandName
  }

  fun withPublisher(publisher: String) = this.apply {
    this.publisher = publisher
  }

  fun withAuthor(author: String) = this.apply {
    this.author = author
  }

  fun build() = RawDataKickResponse(
      gtin14 = id,
      name = name,
      brand_name = brandName,
      publisher = publisher,
      author = author
  )
}

fun aRawDataKickResponseBuilder() = RawDataKickResponseBuilder()
