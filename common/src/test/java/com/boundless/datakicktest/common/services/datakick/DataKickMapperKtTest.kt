package com.boundless.datakicktest.common.services.datakick

import com.boundless.datakicktest.common.entities.Book
import com.boundless.datakicktest.common.entities.FoodItem
import com.boundless.datakicktest.testinfastructure.aRawDataKickResponseBuilder
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldEqual
import org.junit.Test

class DataKickMapperKtTest {

  @Test
  fun listOfMixedProductResponsesMappedCorrectly() {
    val brandName = "kellogs"
    val foodItemResponse = aRawDataKickResponseBuilder().withBrandName(brandName).build()
    val publisher = "harper"
    val bookResponse = aRawDataKickResponseBuilder()
        .withPublisher(publisher)
        .withAuthor("author")
        .build()
    val responses = listOf(foodItemResponse, bookResponse)

    val result = responses.mapToProducts()

    result.size shouldEqual 2
    result[0] shouldBeInstanceOf FoodItem::class.java
    result[1] shouldBeInstanceOf Book::class.java
  }

  @Test
  fun listOfFoodItemResponsesMappedCorrectly() {
    val brandName = "kellogs"
    val foodItemResponse = aRawDataKickResponseBuilder().withBrandName(brandName).build()
    val responses = listOf(foodItemResponse)

    val result = responses.mapToProducts()

    val resultFoodItem = result[0] as FoodItem
    resultFoodItem.brandName shouldEqual brandName
  }

  @Test
  fun listOfBookResponsesMappedCorrectly() {
    val publisher = "harper"
    val bookResponse = aRawDataKickResponseBuilder()
        .withPublisher(publisher)
        .withAuthor("author")
        .build()
    val responses = listOf(bookResponse)

    val result = responses.mapToProducts()

    val resultBook = result[0] as Book
    resultBook.publisher shouldEqual publisher
  }
}
