package com.mattcianna.tvpowerlistener.utils

import android.util.Log
import com.mattcianna.tvpowerlistener.config.Config
import okhttp3.*
import java.io.IOException

object LightUtils {
    fun sendRequestToIFTTT(action: String) {
        val link = "https://maker.ifttt.com/trigger/$action/with/key/${Config.iftttKey}"
        val request = Request.Builder()
            .url(link)
            .get()
            .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("TVPowerListener", "Cannot perform request", e)
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("TVPowerListener", response.toString())
            }
        })
    }

}