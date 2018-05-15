package com.boundless.datakicktest.common.repositories

import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.services.datakick.DataKickService
import io.reactivex.Single

class ProductsRepository(
    private val dataKickService: DataKickService
) {

  private var cachedProducts: List<Product>? = null

  fun fetchProducts(): Single<List<Product>> {
    return if (cachedProducts == null)
      fetchProductsFromNetwork()
    else
      Single.just(cachedProducts)
  }

  private fun fetchProductsFromNetwork(): Single<List<Product>> =
      dataKickService.fetchProducts()
          .doOnSuccess { cachedProducts = it }
}
