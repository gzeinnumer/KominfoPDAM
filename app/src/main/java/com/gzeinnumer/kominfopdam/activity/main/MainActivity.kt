package com.gzeinnumer.kominfopdam.activity.main

import android.view.View
import com.gzeinnumer.kominfopdam.R
import com.gzeinnumer.kominfopdam.activity.base.BaseActivity
import com.gzeinnumer.kominfopdam.activity.gangguan.LaporanGanguanActivity
import com.gzeinnumer.kominfopdam.activity.historytagihan.HistoryTagihanActivity
import com.gzeinnumer.kominfopdam.activity.login.LoginActivity
import com.gzeinnumer.kominfopdam.activity.pasangbaru.PasangBaruActivity
import com.gzeinnumer.kominfopdam.activity.tagihanterkini.TagihanTerkiniActivity
import com.gzeinnumer.kominfopdam.helper.PreferencesUser
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity(), View.OnClickListener {

    private lateinit var preferencesUser: PreferencesUser

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_pasang_baru-> startActivity<PasangBaruActivity>()
            R.id.btn_gangguan-> startActivity<LaporanGanguanActivity>()
            R.id.btn_tagihan_terkini-> startActivity<TagihanTerkiniActivity>()
            R.id.btn_history_tagihan-> startActivity<HistoryTagihanActivity>()
            R.id.btn_logout-> {
                preferencesUser.removeUser()
                startActivity<LoginActivity>()
                finish()
            }
        }
    }

    override fun contentView(): Int {
        return R.layout.activity_main
    }

    override fun initObject() {
        preferencesUser = PreferencesUser(this)
        btn_pasang_baru.setOnClickListener(this)
        btn_tagihan_terkini.setOnClickListener(this)
        btn_history_tagihan.setOnClickListener(this)
        btn_gangguan.setOnClickListener(this)
        btn_logout.setOnClickListener(this)
    }

    override fun onCreatedProcess() {
        onCheckSesion()
    }

    private fun onCheckSesion() {
        if(preferencesUser.getIdCust() == null)
            startActivity<LoginActivity>()
    }
}
