package com.boundless.datakicktest.common.ui.states

data class FoodItemViewState(
    val name: String = "Food Name",
    val brand: String = "Brand",
    val size: String = "Size",
    val servingSize: String = "Serving Size",
    val servingsPerContainer: String = "Servings per Container"
) : ProductViewState
