package com.boundless.datakicktest.common.usecases

import com.boundless.datakicktest.common.entities.Book
import com.boundless.datakicktest.common.entities.FoodItem
import com.boundless.datakicktest.common.repositories.ProductsRepository
import com.boundless.datakicktest.common.ui.states.ProductViewState

class ProductFetcher(
    private val productsRepository: ProductsRepository
) {

  fun allProducts(): List<ProductViewState> {
      return productsRepository.fetchProducts()
              .mapToProductViewStates()
  }

  fun books(): List<ProductViewState> {
      return productsRepository.fetchProducts()
              .filter { it is Book }
              .mapToProductViewStates()
  }

  fun food(): List<ProductViewState> {
      return productsRepository.fetchProducts()
              .filter { it is FoodItem }
              .mapToProductViewStates()
  }
}
