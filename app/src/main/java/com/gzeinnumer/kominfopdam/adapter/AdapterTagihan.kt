package com.gzeinnumer.kominfopdam.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gzeinnumer.kominfopdam.R
import com.gzeinnumer.kominfopdam.model.ResultBillItem
import kotlinx.android.synthetic.main.item.view.*

class AdapterTagihan(private val list: List<ResultBillItem?>?,
                     private val listener: (ResultBillItem) -> Unit):
    RecyclerView.Adapter<AdapterTagihan.MyHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder = MyHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item,parent, false))

    override fun getItemCount(): Int = list?.size!!

    override fun onBindViewHolder(holder: MyHolder, position: Int){
        list?.get(position)?.let{ holder.bindItem(it, listener)}
    }

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SimpleDateFormat")
        fun bindItem(
            data: ResultBillItem,
            listener: (ResultBillItem) -> Unit
        ){
            itemView.id_bill.text = data.idBill
            itemView.id_cust.text = data.idCust
            itemView.bln_hitung.text = data.blnHitung
            itemView.jlm_pakai.text = data.jlmPakai
            itemView.setOnClickListener{
                listener(data)
            }
        }
    }
}