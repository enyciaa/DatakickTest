package com.boundless.datakicktest.common.services.datakick

import com.boundless.datakicktest.common.entities.Book
import com.boundless.datakicktest.common.entities.FoodItem
import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.services.datakick.entities.RawDataKickResponse

fun List<RawDataKickResponse>.mapToProducts(): List<Product> {
  return map {
    when {
      it.isFoodItem() -> it.mapToFoodItem()
      it.isBook() -> it.mapToBook()
      else -> null
    }
  }.filterNotNull()
}

private fun RawDataKickResponse.isFoodItem(): Boolean =
    brandName != null || size != null || servingSize != null || servingsPerContainer != null

private fun RawDataKickResponse.isBook(): Boolean =
    publisher != null || author != null || format != null

private fun RawDataKickResponse.mapToFoodItem(): FoodItem = FoodItem(
    gtin14.orEmpty(),
    name.orEmpty(),
    brandName.orEmpty(),
    size.orEmpty(),
    servingSize.orEmpty(),
    servingsPerContainer.orEmpty()
)

private fun RawDataKickResponse.mapToBook(): Book = Book(
    gtin14.orEmpty(),
    name.orEmpty(),
    publisher.orEmpty(),
    author.orEmpty(),
    pages.orZero(),
    format.orEmpty()
)

private fun String?.orEmpty(): String = this ?: ""

private fun Int?.orZero(): Int = this ?: 0