package com.gzeinnumer.kominfopdam.model

import com.google.gson.annotations.SerializedName

data class ResultBillItem(

	@field:SerializedName("id_bill")
	val idBill: String? = null,

	@field:SerializedName("bln_hitung")
	val blnHitung: String? = null,

	@field:SerializedName("id_type")
	val idType: String? = null,

	@field:SerializedName("id_cust")
	val idCust: String? = null,

	@field:SerializedName("jlm_pakai")
	val jlmPakai: String? = null
)