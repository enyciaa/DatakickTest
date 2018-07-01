package com.boundless.datakicktest.common.ui.model

import com.boundless.datakicktest.common.ui.states.BookItemViewState
import com.boundless.datakicktest.common.ui.states.FoodItemViewState
import com.boundless.datakicktest.common.usecases.mapToProductViewStates
import com.boundless.datakicktest.testinfastructure.BookBuilder
import com.boundless.datakicktest.testinfastructure.FoodItemBuilder
import com.boundless.datakicktest.testinfastructure.aBookBuilder
import com.boundless.datakicktest.testinfastructure.aFoodItemBuilder
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldEqual
import org.junit.Test

class ProductMapperKtTest {

  @Test
  fun listOfMixedProductsMappedCorrectly() {
    val foodItem = aFoodItemBuilder().build()
    val book = aBookBuilder().build()
    val products = listOf(foodItem, book)

    val result = products.mapToProductViewStates()

    result.size shouldEqual 2
    result[0] shouldBeInstanceOf FoodItemViewState::class.java
    result[1] shouldBeInstanceOf BookItemViewState::class.java
  }

  @Test
  fun listOfFoodItemProductsMappedCorrectly() {
    val foodItemResponse = aFoodItemBuilder().build()
    val products = listOf(foodItemResponse)

    val result = products.mapToProductViewStates()

    val resultFoodItem = result[0] as FoodItemViewState
    resultFoodItem.name shouldEqual FoodItemBuilder.DEFAULT_NAME
  }

  @Test
  fun listOfBookProductsMappedCorrectly() {
    val bookResponse = aBookBuilder().build()
    val products = listOf(bookResponse)

    val result = products.mapToProductViewStates()

    val resultBook = result[0] as BookItemViewState
    resultBook.name shouldEqual BookBuilder.DEFAULT_NAME
  }
}
