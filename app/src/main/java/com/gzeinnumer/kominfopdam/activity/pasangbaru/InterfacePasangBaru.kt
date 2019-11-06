package com.gzeinnumer.kominfopdam.activity.pasangbaru

import com.gzeinnumer.kominfopdam.activity.base.BaseView

interface InterfacePasangBaru: BaseView{
    abstract fun onSuksesMsg(pesan: String)
    fun onFailedMsg(s: String)
    fun onSuccesTambahData(s: String)

}