package com.gzeinnumer.kominfopdam.activity.gangguan

import com.gzeinnumer.kominfopdam.helper.UtilHelper
import com.gzeinnumer.kominfopdam.network.RetroServer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PresenterLaporan(private var interfacegangguan: InterfaceGangguan) {
    fun fetchData(keterangan: String) {
        UtilHelper.MyLogD("fetchData")
        interfacegangguan.onShowLoading()
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val call = RetroServer.RetroServerInit().gangguan(keterangan)
                val response = call.await()
                if (response.body()?.kode == 201) {
                    interfacegangguan.onSuccesFetchData()
                    interfacegangguan.onSuksesMsg(response.body()?.pesan!!)
                } else{
                    interfacegangguan.onFailedMsg("Gagal kirim gangguan")
                }
                interfacegangguan.onHideLoading()
            } catch (e: Exception) {
                interfacegangguan.onFailedMsg(e.message)
                interfacegangguan.onHideLoading()
            }
        }
    }

}
