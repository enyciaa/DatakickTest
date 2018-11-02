package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.DispatcherProvider
import com.boundless.datakicktest.common.ui.states.MainViewState
import com.boundless.datakicktest.common.usecases.ProductFetcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
        private val dispatcherProvider: DispatcherProvider,
        private val productFetcher: ProductFetcher
) : MotherViewModel<MainViewState>(dispatcherProvider) {

    override var lastViewState: MainViewState = MainViewState()

    override fun onAttach() {
        super.onAttach()
        emitViewState(lastViewState)
        showAllProducts()
    }

    fun showAllProducts() {
        coroutineScope.launch {
            try {
                val allProducts = withContext(dispatcherProvider.background) { productFetcher.allProducts() }
                emitViewState(lastViewState.withProducts(allProducts))
            } catch (exception: Exception) {
                // Handle custom errors here
                emitViewState(lastViewState.copy(errorState = true))
            }
        }
    }

    fun filterByBooks() {
        coroutineScope.launch {
            try {
                val books = withContext(dispatcherProvider.background) { productFetcher.books() }
                emitViewState(lastViewState.withProducts(books))
            } catch (exception: Exception) {
                // Handle custom errors here
                emitViewState(lastViewState.copy(errorState = true))
            }
        }
    }

    fun filterByFood() {
        coroutineScope.launch {
            try {
                val food = withContext(dispatcherProvider.background) { productFetcher.food() }
                emitViewState(lastViewState.withProducts(food))
            } catch (exception: Exception) {
                // Handle custom errors here
                emitViewState(lastViewState.copy(errorState = true))
            }
        }
    }
}
