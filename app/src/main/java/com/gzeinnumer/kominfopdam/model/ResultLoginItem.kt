package com.gzeinnumer.kominfopdam.model

import com.google.gson.annotations.SerializedName

data class ResultLoginItem(

	@field:SerializedName("id_status")
	val idStatus: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("pass")
	val pass: String? = null,

	@field:SerializedName("id_cust")
	val idCust: String? = null,

	@field:SerializedName("no_telp")
	val noTelp: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null
)