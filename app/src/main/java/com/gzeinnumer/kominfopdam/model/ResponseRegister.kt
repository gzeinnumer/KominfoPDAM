package com.gzeinnumer.kominfopdam.model

import com.google.gson.annotations.SerializedName

data class ResponseRegister(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("kode")
	val kode: Int? = null
)