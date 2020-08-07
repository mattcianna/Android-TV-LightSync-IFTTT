package com.mattcianna.tvpowerlistener.config

import android.content.Context
import java.util.*

object Config {
    private const val configFileName = "app_config.properties"

    lateinit var iftttKey: String
    lateinit var lightOnAction: String
    lateinit var lightOffAction: String

    fun loadConfigs(context: Context) {
        val properties = Properties()
        val inputStream = context.assets.open(configFileName)
        properties.load(inputStream)
        iftttKey = properties.getProperty("ifttt_key")
        lightOnAction = properties.getProperty("light_on_action")
        lightOffAction = properties.getProperty("light_off_action")
    }
}