package com.boundless.datakicktest

import android.app.Activity
import android.app.Application
import com.boundless.datakicktest.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MyApplication : Application(), HasActivityInjector {

  @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

  override fun onCreate() {
    super.onCreate()
    configureDagger()
  }

  private fun configureDagger() {
    DaggerApplicationComponent.builder()
        .provideApplication(this)
        .build()
        .inject(this)
  }

  override fun activityInjector(): AndroidInjector<Activity>? {
    return dispatchingActivityInjector
  }
}
