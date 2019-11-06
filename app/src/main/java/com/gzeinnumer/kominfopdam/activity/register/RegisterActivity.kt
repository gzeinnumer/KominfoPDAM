package com.gzeinnumer.kominfopdam.activity.register

import android.view.View
import com.gzeinnumer.kominfopdam.R
import com.gzeinnumer.kominfopdam.activity.base.BaseActivity
import com.gzeinnumer.kominfopdam.activity.login.LoginActivity
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_pasang_baru.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.ed_alamat
import kotlinx.android.synthetic.main.activity_register.ed_nama
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseActivity() , InterfacesRegister, View.OnClickListener{

    var presenterRegister : PresenterRegister? = null

    private lateinit var alertDialog: android.app.AlertDialog


    override fun contentView(): Int {
        return R.layout.activity_register
    }

    override fun initObject() {
        presenterRegister = PresenterRegister(this)
        alertDialog = SpotsDialog.Builder()
            .setContext(this)
            .setMessage("Mohon Menunggu")
            .setCancelable(false)
            .build()
        btn_register.setOnClickListener(this)
        btn_login.setOnClickListener(this)
    }

    override fun onCreatedProcess() {

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_register-> presenterRegister?.onRegisterValidate(
                ed_username.text.toString(),
                ed_pass.text.toString(),
                ed_nama.text.toString(),
                ed_alamat.text.toString(),
                ed_telp.text.toString())
            R.id.btn_login-> startActivity<LoginActivity>()
        }
    }

    override fun onSuccesRegister() {
        startActivity<LoginActivity>()
    }

    override fun onFailedMsg(s: String?) {
        toast(s!!)
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

    override fun onSuksesMsg(pesan: String) {
        toast(pesan)
    }
}
