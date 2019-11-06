package com.gzeinnumer.kominfopdam.activity.login

import com.gzeinnumer.kominfopdam.activity.base.BaseView

interface InterfacesLogin : BaseView {
    fun onFailedMsg(s: String?)
    fun onSuccesLogin()
}