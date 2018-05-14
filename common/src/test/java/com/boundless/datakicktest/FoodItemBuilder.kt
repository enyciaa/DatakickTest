package com.boundless.datakicktest

import com.boundless.datakicktest.common.entities.FoodItem

class FoodItemBuilder {

  companion object {
    val DEFAULT_ID = "id"
    val DEFAULT_NAME = "name"
    val DEFAULT_BRAND = "brand"
  }

  private var id = DEFAULT_ID
  private var name = DEFAULT_NAME
  private var brandName = DEFAULT_BRAND

  fun withBrandName(brandName: String) = this.apply {
    this.brandName = brandName
  }

  fun build() = FoodItem(
      id,
      name,
      brandName
  )
}

fun aFoodItemBuilder() = FoodItemBuilder()