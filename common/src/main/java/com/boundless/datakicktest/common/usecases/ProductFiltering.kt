package com.boundless.datakicktest.common.usecases

import com.boundless.datakicktest.common.entities.Book
import com.boundless.datakicktest.common.entities.FoodItem
import com.boundless.datakicktest.common.entities.Product

fun List<Product>.filterByBooks(): List<Product> =
    filter { it is Book }

fun List<Product>.filterByFood(): List<Product> =
    filter { it is FoodItem }
