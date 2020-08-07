package com.mattcianna.tvpowerlistener

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import com.mattcianna.tvpowerlistener.receivers.MyScreenReceiver

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
