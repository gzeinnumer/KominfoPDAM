package com.gzeinnumer.kominfopdam.activity.tagihanterkini

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gzeinnumer.kominfopdam.R
import com.gzeinnumer.kominfopdam.activity.base.BaseActivity
import com.gzeinnumer.kominfopdam.activity.gangguan.PresenterLaporan
import com.gzeinnumer.kominfopdam.adapter.AdapterTagihan
import com.gzeinnumer.kominfopdam.model.ResultBillItem
import kotlinx.android.synthetic.main.activity_tagihan_terkini.*
import org.jetbrains.anko.toast

class TagihanTerkiniActivity : BaseActivity(), InterfaceTagihanTerkini {

    var presenter : PresenterTagihanTerkini? = null
    override fun contentView(): Int {
        return R.layout.activity_tagihan_terkini
    }

    override fun initObject() {
        presenter = PresenterTagihanTerkini(this)
    }

    override fun onCreatedProcess() {

        initData()
    }

    private fun initData() {
        presenter?.getData()
    }

    override fun onSuksesGetData(resultBill: List<ResultBillItem?>) {
        rv_terkini.apply {
            adapter = AdapterTagihan(resultBill){

            }
            layoutManager= LinearLayoutManager(this@TagihanTerkiniActivity)
            hasFixedSize()
        }
    }

    override fun onFailedMsg(message: String?) {
        toast(message!!)
    }

    override fun onShowLoading() {
    }

    override fun onHideLoading() {
    }
}
