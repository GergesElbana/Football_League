package com.app.gergese_elbana.football_league.data.remote.network

import android.content.Context
import android.content.SharedPreferences
import okhttp3.Interceptor

class HeaderInterceptor (private val context : Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("SharedPreferencesManager", Context.MODE_PRIVATE)
        val token: String? = sharedPreferences.getString("loginToken", null)
        val request = chain.request().newBuilder()
//            .addHeader("Accept", "application/json")
//            .addHeader("Accept-Language", "ar")
//            .addHeader("App-Version", "11")
//            .addHeader("Device-Name","iphone 11 pro")
//            .addHeader("Device-OS-Version","13")
//            .addHeader("Device-UDID","1234")
//            .addHeader("Device-Push-Token","123456")
//            .addHeader("Device-Type","ios")
//            .addHeader("Authorization", "Bearer $token")
            .build()
        return chain.proceed(request)
    }
}