package com.gzeinnumer.kominfopdam.helper

import android.content.Context
import android.content.SharedPreferences

class PreferencesUser (context: Context) {
    private var sharedPreferences: SharedPreferences
    private var editor: SharedPreferences.Editor

    private val prefFileName = "user"

    val id_us = "id_us"

    init {
        sharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.apply()
    }

    fun createDataKaryawan(idUser: String?) {
        idUser?.let { editor.putString(this.id_us, it) }
        editor.commit()
    }

    fun getIdCust(): String? = sharedPreferences.getString(id_us,null)

    fun removeUser() {
        editor.clear()
        editor.commit()
    }
}