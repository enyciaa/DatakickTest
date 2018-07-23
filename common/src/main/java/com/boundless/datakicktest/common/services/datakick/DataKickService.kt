package com.boundless.datakicktest.common.services.datakick

import com.boundless.datakicktest.common.entities.Product

class DataKickService(
    private val dataKickApi: DataKickApi
) {

  suspend fun fetchProducts(): List<Product> =
      dataKickApi.fetchItems().await()
          .mapToProducts()

}
