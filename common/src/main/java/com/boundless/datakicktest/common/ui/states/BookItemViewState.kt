package com.boundless.datakicktest.common.ui.states

data class BookItemViewState(
        val name: String = "Book Name",
        val author: String = "Janice Lane",
        val bookType: String = "Hardcover",
        val numberOfPage: String = "172 Pages",
        val publisher: String = "Harper Collins"
) : ProductViewState
