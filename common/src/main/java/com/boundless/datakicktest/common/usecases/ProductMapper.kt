package com.boundless.datakicktest.common.usecases

import com.boundless.datakicktest.common.entities.Book
import com.boundless.datakicktest.common.entities.FoodItem
import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.ui.states.BookItemViewState
import com.boundless.datakicktest.common.ui.states.FoodItemViewState
import com.boundless.datakicktest.common.ui.states.ProductViewState

fun List<Product>.mapToProductViewStates(): List<ProductViewState> =
        map {
            when (it) {
                is Book     -> it.mapToBookItemViewState()
                is FoodItem -> it.mapToFoodItemViewState()
                else        -> null
            }
        }.filterNotNull()

private fun FoodItem.mapToFoodItemViewState(): FoodItemViewState =
        FoodItemViewState(
                name,
                brandName,
                size,
                servingSize,
                servingsPerContainer
        )

private fun Book.mapToBookItemViewState(): BookItemViewState =
        BookItemViewState(
                name,
                author,
                bookType,
                getNumberOfPagesToDisplay(),
                publisher
        )

private fun Book.getNumberOfPagesToDisplay() =
        if (numberOfPages > 0)
            "$numberOfPages Pages"
        else
            ""
