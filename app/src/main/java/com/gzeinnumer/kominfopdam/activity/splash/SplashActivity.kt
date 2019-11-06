package com.gzeinnumer.kominfopdam.activity.splash

import android.os.Handler
import com.gzeinnumer.kominfopdam.R
import com.gzeinnumer.kominfopdam.activity.base.BaseActivity
import com.gzeinnumer.kominfopdam.activity.main.MainActivity
import org.jetbrains.anko.startActivity

class SplashActivity : BaseActivity() {

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000

    override fun contentView(): Int {
        return R.layout.activity_splash
    }

    override fun initObject() {

    }

    override fun onCreatedProcess() {

        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            startActivity<MainActivity>()
            finish()
        }
    }

    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }
}
