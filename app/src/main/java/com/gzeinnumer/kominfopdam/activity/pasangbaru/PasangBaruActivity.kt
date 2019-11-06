package com.gzeinnumer.kominfopdam.activity.pasangbaru

import android.graphics.Color
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.gzeinnumer.kominfopdam.R
import com.gzeinnumer.kominfopdam.activity.base.BaseActivity
import com.gzeinnumer.kominfopdam.activity.main.MainActivity
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_pasang_baru.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class PasangBaruActivity : BaseActivity() , InterfacePasangBaru, View.OnClickListener{

    private lateinit var alertDialog: android.app.AlertDialog

    var presenter : PresenterPasangBaru? = null

    override fun contentView(): Int {
        return R.layout.activity_pasang_baru
    }

    override fun initObject() {
        alertDialog = SpotsDialog.Builder()
            .setContext(this)
            .setMessage("Mohon Menunggu")
            .setCancelable(false)
            .build()
        presenter= PresenterPasangBaru(this)
        btn_tambah.setOnClickListener(this)
    }

    override fun onCreatedProcess() {

    }

    override fun onClick(v: View?) {
        presenter?.OnValidateSenData(
            ed_nama.text.toString(),
            ed_alamat.text.toString(),
            ed_no_telp.text.toString()
        )
    }

    override fun onSuksesMsg(pesan: String) {
        toast(pesan)

    }

    override fun onFailedMsg(s: String) {
        toast(s)
    }

    override fun onSuccesTambahData(s: String) {
        alert("Permintaan anda akan kami proses") {
            positiveButton("Oke") {
                it.dismiss()
                startActivity<MainActivity>()
                finish()
            }
            isCancelable = false
        }.show().apply {
            getButton(AlertDialog.BUTTON_POSITIVE)?.let {
                it.setBackgroundColor(Color.TRANSPARENT)
                it.setTextColor(ContextCompat.getColor(this@PasangBaruActivity, R.color.colorPrimary))
            }
        }
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
