package com.gzeinnumer.kominfopdam.activity.login

import com.gzeinnumer.kominfopdam.helper.MyApp
import com.gzeinnumer.kominfopdam.helper.PreferencesUser
import com.gzeinnumer.kominfopdam.helper.UtilHelper
import com.gzeinnumer.kominfopdam.network.RetroServer.Companion.RetroServerInit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class PresenterLogin(private val interfacesLogin: InterfacesLogin) {
    fun onLoginValidate(username: String?, password: String?) {
        UtilHelper.MyLogD("onRegisterValidate")
        interfacesLogin.onShowLoading()
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val call = RetroServerInit().login(username, password)
                val response = call.await()
                if (response.isSuccessful) {
                    if (response.body()?.resultLogin?.isNotEmpty()!!){
                        val preferencesUser = MyApp.context?.let { it1 ->
                            PreferencesUser(it1)
                        }
                        preferencesUser?.createDataKaryawan(
                            response.body()?.resultLogin?.get(0)?.idCust
                        )
                        interfacesLogin.onSuccesLogin()
                    }
                }
                interfacesLogin.onHideLoading()
            } catch (e: Exception) {
                interfacesLogin.onFailedMsg(e.message)
                interfacesLogin.onHideLoading()
            }
        }
    }


}