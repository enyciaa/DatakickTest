package com.boundless.datakicktest.common.ui.states

data class MainViewState(
        val products: List<ProductViewState> = listOf(),
        val errorState: Boolean = false
) : ViewState {

    fun withProducts(products: List<ProductViewState>): MainViewState {
        return this.copy(
                products = products,
                errorState = false
        )
    }
}
