package com.gzeinnumer.kominfopdam.activity.gangguan

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gzeinnumer.kominfopdam.R
import com.gzeinnumer.kominfopdam.activity.base.BaseActivity
import com.gzeinnumer.kominfopdam.activity.main.MainActivity
import com.gzeinnumer.kominfopdam.activity.pasangbaru.PresenterPasangBaru
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_laporan_ganguan.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LaporanGanguanActivity : BaseActivity(), InterfaceGangguan, View.OnClickListener {

    private lateinit var alertDialog: android.app.AlertDialog
    var presenter: PresenterLaporan? = null


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.img -> {

            }
            R.id.btn_kirim -> {
                presenter?.fetchData(ed_laporan.text.toString())
            }
        }
    }

    override fun contentView(): Int {
        return R.layout.activity_laporan_ganguan
    }

    override fun initObject() {
        alertDialog = SpotsDialog.Builder()
            .setContext(this)
            .setMessage("Mohon Menunggu")
            .setCancelable(false)
            .build()
        presenter = PresenterLaporan(this)
        img.setOnClickListener(this)
        btn_kirim.setOnClickListener(this)
    }

    override fun onCreatedProcess() {

    }

    override fun onSuksesMsg(pesan: String) {
        toast(pesan)
    }

    override fun onFailedMsg(message: String?) {
        toast(message!!)
    }

    override fun onSuccesFetchData() {
        startActivity<MainActivity>()
        finish()
    }

    override fun onShowLoading() {
        alertDialog.apply {
            show()
        }
    }

    override fun onHideLoading() {
        alertDialog.apply {
            dismiss()
        }
    }

}
