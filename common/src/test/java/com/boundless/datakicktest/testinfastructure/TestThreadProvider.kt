package com.boundless.datakicktest.testinfastructure

import com.boundless.elephant.threading.ThreadProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestThreadProvider : ThreadProvider {

  override val computation: Scheduler
    get() = Schedulers.trampoline()

  override val io: Scheduler
    get() = Schedulers.trampoline()

  override val main: Scheduler
    get() = Schedulers.trampoline()

  override val new: Scheduler
    get() = Schedulers.trampoline()

  override val single: Scheduler
    get() = Schedulers.trampoline()

  override val trampoline: Scheduler
    get() = Schedulers.trampoline()
}
