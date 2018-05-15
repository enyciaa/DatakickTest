package com.boundless.datakicktest.common.services.datakick

import com.boundless.datakicktest.common.entities.Product
import io.reactivex.Single

class DataKickService(
    private val dataKickApi: DataKickApi
) {

  fun fetchProducts(): Single<List<Product>> =
    dataKickApi.fetchItems()
        .map { it.mapToProducts() }

}
