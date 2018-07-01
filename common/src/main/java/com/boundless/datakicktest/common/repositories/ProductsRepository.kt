package com.boundless.datakicktest.common.repositories

import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.services.datakick.DataKickService

class ProductsRepository(
    private val dataKickService: DataKickService
) {

  private var cachedProducts: List<Product>? = null

  suspend fun fetchProducts(): List<Product> =
    cachedProducts ?: fetchProductsFromNetwork()

  private suspend fun fetchProductsFromNetwork(): List<Product> {
    val products = dataKickService.fetchProducts()
    cachedProducts = products
    return products
  }
}
