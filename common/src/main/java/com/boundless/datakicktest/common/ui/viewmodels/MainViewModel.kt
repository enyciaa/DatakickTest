package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.ui.states.MainViewState
import com.boundless.datakicktest.common.usecases.ProductFetcher
import kotlinx.coroutines.experimental.launch

class MainViewModel(
        private val coreRoutineContextProvider: CoreroutineContextProvider,
        private val productFetcher: ProductFetcher
) : MotherViewModel<MainViewState>() {

    override var lastViewState: MainViewState = MainViewState()

    override fun onAttach() {
        super.onAttach()
        emitViewState(lastViewState)
        showAllProducts()
    }

    fun showAllProducts() {
        launch(coreRoutineContextProvider.commonPool, parent = coreroutineManager)  {
            try {
                val allProducts = productFetcher.allProducts()
                emitViewState(lastViewState.withProducts(allProducts))
            } catch (exception: Exception) {
                // Handle custom errors here
                emitViewState(lastViewState.copy(errorState = true))
            }
        }
    }

    fun filterByBooks() {
        launch(coreRoutineContextProvider.commonPool, parent = coreroutineManager)  {
            try {
                val books = productFetcher.books()
                emitViewState(lastViewState.withProducts(books))
            } catch (exception: Exception) {
                // Handle custom errors here
                emitViewState(lastViewState.copy(errorState = true))
            }
        }
    }

    fun filterByFood() {
        launch(coreRoutineContextProvider.commonPool, parent = coreroutineManager)  {
            try {
                val food = productFetcher.food()
                emitViewState(lastViewState.withProducts(food))
            } catch (exception: Exception) {
                // Handle custom errors here
                emitViewState(lastViewState.copy(errorState = true))
            }

        }
    }
}
