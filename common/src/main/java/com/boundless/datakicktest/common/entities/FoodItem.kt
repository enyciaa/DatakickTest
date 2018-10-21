package com.boundless.datakicktest.common.entities

data class FoodItem(
        val id: String,
        val name: String,
        val brandName: String,
        val size: String,
        val servingSize: String,
        val servingsPerContainer: String
) : Product
