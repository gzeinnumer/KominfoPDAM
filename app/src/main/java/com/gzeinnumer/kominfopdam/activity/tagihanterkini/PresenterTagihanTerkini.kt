package com.gzeinnumer.kominfopdam.activity.tagihanterkini

import com.gzeinnumer.kominfopdam.helper.MyApp
import com.gzeinnumer.kominfopdam.helper.PreferencesUser
import com.gzeinnumer.kominfopdam.network.RetroServer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PresenterTagihanTerkini(private var interfaceTagihanTerkini: InterfaceTagihanTerkini) {
    fun getData() {
        interfaceTagihanTerkini.onShowLoading()
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val call = RetroServer.RetroServerInit().getData()
                val response = call.await()
                if (response.isSuccessful) {
                    if (response.body()?.resultBill?.isNotEmpty()!!){
                        interfaceTagihanTerkini.onSuksesGetData(response.body()?.resultBill!!)
                    }
                }
                interfaceTagihanTerkini.onHideLoading()
            } catch (e: Exception) {
                interfaceTagihanTerkini.onFailedMsg(e.message)
                interfaceTagihanTerkini.onHideLoading()
            }
        }
    }
}
