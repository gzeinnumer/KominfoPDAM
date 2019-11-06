package com.gzeinnumer.kominfopdam.activity.register

import com.gzeinnumer.kominfopdam.helper.MyApp
import com.gzeinnumer.kominfopdam.helper.PreferencesUser
import com.gzeinnumer.kominfopdam.helper.UtilHelper
import com.gzeinnumer.kominfopdam.network.RetroServer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PresenterRegister(private val interfaceRegister: InterfacesRegister) {
    fun onRegisterValidate(
        username: String,
        pass: String,
        name: String,
        alamat: String,
        telp: String
    ) {
        UtilHelper.MyLogD("onRegisterValidate")
        interfaceRegister.onShowLoading()
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val call = RetroServer.RetroServerInit().register(username, pass, name, alamat, telp)
                val response = call.await()
                if (response.body()?.kode == 201) {
                    interfaceRegister.onSuccesRegister()
                    interfaceRegister.onSuksesMsg(response.body()?.pesan!!)
                } else {
                    interfaceRegister.onFailedMsg("Gagal Register")
                }
                interfaceRegister.onHideLoading()
            } catch (e: Exception) {
                interfaceRegister.onFailedMsg(e.message)
                interfaceRegister.onHideLoading()
            }
        }


    }

}
