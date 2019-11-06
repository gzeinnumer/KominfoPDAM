package com.gzeinnumer.kominfopdam.network

import com.gzeinnumer.kominfopdam.model.ResponseLogin
import com.gzeinnumer.kominfopdam.model.ResponseReadBill
import com.gzeinnumer.kominfopdam.model.ResponseRegister
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("username") username: String?,
              @Field("pass") pass: String?
    ) : Deferred<Response<ResponseLogin>>

    @FormUrlEncoded
    @POST("register_costumer.php")
    fun register(@Field("username") username: String?,
              @Field("pass") pass: String?,
             @Field("nama") nama: String?,
                 @Field("alamat") ala: String?,
                 @Field("no_telp") no: String?
    ) : Deferred<Response<ResponseRegister>>

    @FormUrlEncoded
    @POST("insert_pasangbaru.php")
    fun registerPasangBaru(@Field("nama") name: String?,
                 @Field("alamat") alamat: String?,
                 @Field("no_telp") hp: String?
    ) : Deferred<Response<ResponseRegister>>

    @FormUrlEncoded
    @POST("insert_gangguan.php")
    fun gangguan(@Field("keterangan") ket: String?
    ) : Deferred<Response<ResponseRegister>>

    @GET("read_bill.php")
    fun getData() : Deferred<Response<ResponseReadBill>>
}
