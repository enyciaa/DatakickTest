package com.boundless.datakicktest.common.ui.model

import com.boundless.datakicktest.common.entities.Book
import com.boundless.datakicktest.common.entities.FoodItem
import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.ui.states.BookItemViewState
import com.boundless.datakicktest.common.ui.states.FoodItemViewState
import com.boundless.datakicktest.common.ui.states.ProductViewState

fun List<Product>.mapToProductViewStates(): List<ProductViewState> =
  map {
    when (it) {
      is Book -> it.mapToBookItemViewState()
      is FoodItem -> it.mapToFoodItemViewState()
      else -> null
    }
  }.filterNotNull()

private fun FoodItem.mapToFoodItemViewState(): FoodItemViewState =
    FoodItemViewState(
        name
    )

private fun Book.mapToBookItemViewState(): BookItemViewState =
    BookItemViewState(
        name
    )
