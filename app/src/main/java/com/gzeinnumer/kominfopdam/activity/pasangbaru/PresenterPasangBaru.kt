package com.gzeinnumer.kominfopdam.activity.pasangbaru

import com.gzeinnumer.kominfopdam.network.RetroServer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PresenterPasangBaru(private val interfacePasangBaru: InterfacePasangBaru){
    fun OnValidateSenData(nama: String, alamat: String, hp: String) {
        interfacePasangBaru.onShowLoading()
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val call = RetroServer.RetroServerInit().registerPasangBaru(nama, alamat, hp)
                val response = call.await()
                if (response.body()?.kode == 201) {
                    interfacePasangBaru.onSuccesTambahData(response.body()?.pesan!!)
                    interfacePasangBaru.onSuksesMsg(response.body()?.pesan!!)
                } else{
                    interfacePasangBaru.onFailedMsg("Gagal Register")
                }
                interfacePasangBaru.onHideLoading()
            } catch (e: Exception) {
                interfacePasangBaru.onFailedMsg(e.message!!)
                interfacePasangBaru.onHideLoading()
            }
        }
    }

}