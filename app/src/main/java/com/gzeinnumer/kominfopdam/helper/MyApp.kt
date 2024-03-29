package com.gzeinnumer.kominfopdam.helper

import android.app.Application
import android.content.Context

class MyApp : Application() {
    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    companion object {
        private var instance: MyApp? = null

        val context: Context?
            get() = instance
    }
}