package com.mattcianna.tvpowerlistener

import android.app.Application
import android.content.Intent
import com.mattcianna.tvpowerlistener.config.Config
import com.mattcianna.tvpowerlistener.services.ForegroundService

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Config.loadConfigs(this)
        val serviceIntent = Intent(this, ForegroundService::class.java)
        startService(serviceIntent)
    }
}