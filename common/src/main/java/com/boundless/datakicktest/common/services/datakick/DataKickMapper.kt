package com.boundless.datakicktest.common.services.datakick

import com.boundless.datakicktest.common.entities.Book
import com.boundless.datakicktest.common.entities.FoodItem
import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.services.datakick.entities.RawDataKickResponse

fun List<RawDataKickResponse>.mapToProducts(): List<Product> {
    return map {
        when {
            it.isFoodItem() -> it.mapToFoodItem()
            it.isBook()     -> it.mapToBook()
            else            -> null
        }
    }.filterNotNull()
}

private fun RawDataKickResponse.isFoodItem(): Boolean =
        name != null && brand_name != null

private fun RawDataKickResponse.isBook(): Boolean =
        name != null && publisher != null && author != null

private fun RawDataKickResponse.mapToFoodItem(): FoodItem =
        FoodItem(
                gtin14.orEmpty(),
                name.orEmpty(),
                brand_name.orEmpty(),
                size.orEmpty(),
                serving_size.orEmpty(),
                servings_per_container.orEmpty()
        )

private fun RawDataKickResponse.mapToBook(): Book =
        Book(
                gtin14.orEmpty(),
                name.orEmpty(),
                publisher.orEmpty(),
                author.orEmpty(),
                pages.orZero(),
                format.orEmpty()
        )

private fun String?.orEmpty(): String = this ?: ""

private fun Int?.orZero(): Int = this ?: 0