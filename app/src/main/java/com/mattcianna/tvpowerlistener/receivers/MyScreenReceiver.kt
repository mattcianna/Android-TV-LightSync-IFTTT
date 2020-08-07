package com.mattcianna.tvpowerlistener.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.mattcianna.tvpowerlistener.config.Config
import com.mattcianna.tvpowerlistener.services.ForegroundService
import com.mattcianna.tvpowerlistener.utils.LightUtils.sendRequestToIFTTT
import okhttp3.*
import java.io.IOException

class MyScreenReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("TVPowerListener", "Received intent: ${intent.action}")

        when(intent.action) {
            Intent.ACTION_SCREEN_OFF -> {
                sendRequestToIFTTT(Config.lightOffAction)
            }
            Intent.ACTION_SCREEN_ON -> {
                sendRequestToIFTTT(Config.lightOnAction)
            }
            // TODO: this is not working on android tv
            Intent.ACTION_BOOT_COMPLETED -> {
                val serviceIntent = Intent(context, ForegroundService::class.java)
                ContextCompat.startForegroundService(context, serviceIntent)
                sendRequestToIFTTT(Config.lightOnAction)
            }
        }
    }

}
