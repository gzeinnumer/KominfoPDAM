package com.gzeinnumer.kominfopdam.activity.tagihanterkini

import com.gzeinnumer.kominfopdam.activity.base.BaseView
import com.gzeinnumer.kominfopdam.model.ResultBillItem

interface InterfaceTagihanTerkini: BaseView {
    fun onSuksesGetData(resultBill: List<ResultBillItem?>)
    fun onFailedMsg(message: String?)

}
