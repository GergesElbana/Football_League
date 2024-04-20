package com.app.gergese_elbana.football_league.utiles

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "SharedPreferencesManager", Context.MODE_PRIVATE
    )

    fun saveSharedData(key: String, value: Any?) {
        val editor = sharedPreferences.edit()

        when (value) {
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Long -> editor.putLong(key, value)
            is Float -> editor.putFloat(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Double ->editor.putFloat(key, value.toFloat())
            else -> throw IllegalArgumentException("Unsupported value type")
        }

        editor.apply()
    }

    fun getSharedData(key: String): Any? {
        return when (val value = sharedPreferences.all[key]) {
            is String, is Int, is Long, is Float, is Boolean -> value
            else -> null
        }
    }


}