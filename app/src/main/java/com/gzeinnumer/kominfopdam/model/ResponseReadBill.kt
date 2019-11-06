package com.gzeinnumer.kominfopdam.model

import com.google.gson.annotations.SerializedName

data class ResponseReadBill(

	@field:SerializedName("kode")
	val kode: Int? = null,

	@field:SerializedName("result_bill")
	val resultBill: List<ResultBillItem?>? = null
)