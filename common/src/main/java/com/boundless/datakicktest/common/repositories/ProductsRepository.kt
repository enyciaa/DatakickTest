package com.boundless.datakicktest.common.repositories

import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.services.datakick.DataKickService

class ProductsRepository(
        private val dataKickService: DataKickService
) {

    private var cachedProducts: List<Product>? = null

    fun fetchProducts(): List<Product> {
        return cachedProducts ?: fetchProductsFromNetwork()
    }

    private fun fetchProductsFromNetwork(): List<Product> {
        val products = dataKickService.fetchProducts()
        cachedProducts = products
        return products
    }
}
