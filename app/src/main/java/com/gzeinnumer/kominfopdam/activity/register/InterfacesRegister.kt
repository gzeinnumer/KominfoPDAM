package com.gzeinnumer.kominfopdam.activity.register

import com.gzeinnumer.kominfopdam.activity.base.BaseView

interface InterfacesRegister : BaseView{
    fun onSuccesRegister()
    fun onFailedMsg(message: String?)
    fun onSuksesMsg(pesan: String)

}
