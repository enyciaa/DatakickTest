package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.ui.states.MainViewState
import com.boundless.datakicktest.common.usecases.ProductFetcher
import kotlinx.coroutines.experimental.async

class MainViewModel(
        coreRoutineContextProvider: CoreroutineContextProvider,
        private val productFetcher: ProductFetcher
) : MotherViewModel<MainViewState>(coreRoutineContextProvider) {

    override var lastViewState: MainViewState = MainViewState()

    override fun onAttach() {
        super.onAttach()
        emitViewState(lastViewState)
        showAllProducts()
    }

    fun filterByBooks() {
        launchDefaultCoreRoutine {
            try {
                val books = productFetcher.books()
                emitViewState(lastViewState.copy(products = books, errorState = false))
            } catch (exception: Exception) {
                emitViewState(lastViewState.copy(errorState = true))
            }
        }
    }

    fun filterByFood() {
        launchDefaultCoreRoutine {
            try {
                val food = productFetcher.food()
                emitViewState(lastViewState.copy(products = food, errorState = false))
            } catch (exception: Exception) {
                emitViewState(lastViewState.copy(errorState = true))
            }

        }
    }

    fun showAllProducts() {
        launchDefaultCoreRoutine {
            try {
                val allProducts = productFetcher.allProducts()
                emitViewState(lastViewState.copy(products = allProducts, errorState = false))
            } catch (exception: Exception) {
                emitViewState(lastViewState.copy(errorState = true))
            }
        }
    }
}
