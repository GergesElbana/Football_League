package com.app.gergese_elbana.football_league.data.remote.network

import android.util.Log
import com.app.gergese_elbana.football_league.utiles.Resource
import retrofit2.Response

abstract class NetworkResult {
    protected suspend fun <T> checkResult(
        request: suspend () -> Response<T>
    ): Resource<T> {
        try {
            val response = request()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }


        } catch (e: Exception) {
            Log.e("ERROR", e.message!!)

        }
        return Resource.error("error with network request", null)
    }
}