package com.mattcianna.tvpowerlistener.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.mattcianna.tvpowerlistener.R
import com.mattcianna.tvpowerlistener.config.Config
import com.mattcianna.tvpowerlistener.receivers.MyScreenReceiver
import com.mattcianna.tvpowerlistener.utils.LightUtils

class ForegroundService : Service() {

    private val channelId = "ForegroundServiceChannel"
    private val receiver = MyScreenReceiver()

    override fun onCreate() {
        super.onCreate()
        registerReceiver(receiver, IntentFilter(Intent.ACTION_BOOT_COMPLETED))
        registerReceiver(receiver, IntentFilter(Intent.ACTION_SCREEN_ON))
        registerReceiver(receiver, IntentFilter(Intent.ACTION_SCREEN_OFF))
        setupNotification()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        setupNotification()
        return START_NOT_STICKY
    }

    private fun setupNotification() {
        createNotificationChannel()

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Light Listener")
            .setContentText("Keep this app open in order to sync TV power with light power.")
            .setSmallIcon(R.mipmap.ic_launcher)
            .build()

        startForeground(1, notification)

        LightUtils.sendRequestToIFTTT(Config.lightOnAction)
    }

    override fun onBind(intent: Intent): IBinder {
        return Binder()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                channelId,
                "Light Listener Foreground Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            val manager = getSystemService(NotificationManager::class.java)
            manager!!.createNotificationChannel(serviceChannel)
        }
    }
}