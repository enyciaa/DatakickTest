package com.boundless.datakicktest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.boundless.datakicktest.ui.MainActivity

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(MainActivity.getIntent(this))
    }
}
