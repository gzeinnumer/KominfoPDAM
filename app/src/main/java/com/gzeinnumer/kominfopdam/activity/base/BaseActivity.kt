package com.gzeinnumer.kominfopdam.activity.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gzeinnumer.kominfopdam.R

abstract class BaseActivity : AppCompatActivity() {

    abstract fun contentView(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentView())
        initObject()
        onCreatedProcess()
    }

    abstract fun initObject()

    abstract fun onCreatedProcess()


}
