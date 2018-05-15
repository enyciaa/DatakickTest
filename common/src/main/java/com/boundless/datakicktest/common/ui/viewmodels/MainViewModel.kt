package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.ui.model.MainModel
import com.boundless.datakicktest.common.ui.states.MainViewState
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable

class MainViewModel(
    private val mainModel: MainModel
) : MotherViewModel() {

  private var lastViewState: MainViewState = MainViewState()
  private val viewState: BehaviorRelay<MainViewState> = BehaviorRelay.createDefault(lastViewState)

  fun getViewState(): Observable<MainViewState> = viewState

  override fun onAttach() {
    super.onAttach()
    mainModel.fetchProducts()
        .subscribe(
            { emitViewState(lastViewState.copy(products = it)) },
            {  }
        )
  }

  fun onButtonClick() {
  }

  private fun emitViewState(newViewState: MainViewState) {
    lastViewState = newViewState
    viewState.accept(newViewState)
  }
}
