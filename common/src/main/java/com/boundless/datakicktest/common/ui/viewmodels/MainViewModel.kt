package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.ui.model.MainModel
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable

class MainViewModel(
    private val mainModel: MainModel
) : MotherViewModel() {

  private val viewState: BehaviorRelay<MainViewState> = BehaviorRelay.createDefault(MainViewState())
  private val lastViewState: MainViewState = MainViewState()

  fun getViewState(): Observable<MainViewState> = viewState

  override fun onAttach() {
    super.onAttach()
    mainModel.fetchValue()
        .subscribe(
            { emitViewState(lastViewState.copy(hello = it.id)) },
            {}
        )
  }

  override fun onDetach() {
    super.onDetach()
  }

  fun onButtonClick() {
  }

  private fun emitViewState(newViewState: MainViewState) {
    viewState.accept(newViewState)
  }
}
