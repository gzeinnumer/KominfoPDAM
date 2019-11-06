package com.gzeinnumer.kominfopdam.activity.gangguan

import com.gzeinnumer.kominfopdam.activity.base.BaseView

interface InterfaceGangguan : BaseView{
    abstract fun onSuksesMsg(pesan: String)
    abstract fun onFailedMsg(message: String?)
    fun onSuccesFetchData()

}
