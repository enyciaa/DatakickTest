package com.boundless.datakicktest.common.entities

data class Book(
        val id: String,
        val name: String,
        val publisher: String,
        val author: String,
        val numberOfPages: Int,
        val bookType: String
) : Product
