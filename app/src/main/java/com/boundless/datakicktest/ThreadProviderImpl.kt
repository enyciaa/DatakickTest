package com.boundless.datakicktest

import com.boundless.elephant.threading.ThreadProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ThreadProviderImpl : ThreadProvider {

  override val computation: Scheduler
    get() = Schedulers.computation()

  override val io: Scheduler
    get() = Schedulers.io()

  override val main: Scheduler
    get() = AndroidSchedulers.mainThread()

  override val new: Scheduler
    get() = Schedulers.newThread()

  override val single: Scheduler
    get() = Schedulers.single()

  override val trampoline: Scheduler
    get() = Schedulers.trampoline()
}
