package com.gzeinnumer.kominfopdam.model

import com.google.gson.annotations.SerializedName

data class ResponseLogin(

	@field:SerializedName("kode")
	val kode: Int? = null,

	@field:SerializedName("result_login")
	val resultLogin: List<ResultLoginItem?>? = null
)