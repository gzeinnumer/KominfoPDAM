package com.gzeinnumer.kominfopdam.activity.login

import android.view.View
import com.gzeinnumer.kominfopdam.R
import com.gzeinnumer.kominfopdam.activity.base.BaseActivity
import com.gzeinnumer.kominfopdam.activity.main.MainActivity
import com.gzeinnumer.kominfopdam.activity.register.RegisterActivity
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity(), View.OnClickListener, InterfacesLogin {

    var presenterLogin :PresenterLogin? = null

    private lateinit var alertDialog: android.app.AlertDialog



    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_login-> presenterLogin?.onLoginValidate(ed_username.text.toString(), ed_pass.text.toString())
            R.id.btn_register-> startActivity<RegisterActivity>()
        }
    }

    override fun contentView(): Int {
        return R.layout.activity_login
    }

    override fun initObject() {
        alertDialog = SpotsDialog.Builder()
            .setContext(this)
            .setMessage("Mohon Menunggu")
            .setCancelable(false)
            .build()
        presenterLogin = PresenterLogin(this)
        btn_login.setOnClickListener(this)
        btn_register.setOnClickListener(this)
    }
    override fun onCreatedProcess() {
        toast("Selamat Datang, silahkan login")
    }

    override fun onFailedMsg(s: String?) {
        toast(s!!)
    }

    override fun onSuccesLogin() {
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
