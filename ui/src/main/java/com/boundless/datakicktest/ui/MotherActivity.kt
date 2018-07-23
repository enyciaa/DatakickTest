package com.boundless.datakicktest.ui

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import com.boundless.datakicktest.common.ui.viewmodels.LifecycleReceiver
import dagger.android.AndroidInjection

abstract class MotherActivity : AppCompatActivity() {

  private val lifecycleReceivers: MutableList<LifecycleReceiver> = mutableListOf()

  abstract fun provideLifecycleReceivers(): List<LifecycleReceiver>

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    lifecycleReceivers.addAll(provideLifecycleReceivers())
  }

  @CallSuper
  override fun onResume() {
    super.onResume()
    lifecycleReceivers.forEach { it.onAttach() }
  }

  @CallSuper
  override fun onPause() {
    super.onPause()
    lifecycleReceivers.forEach { it.onDetach() }
  }
}
