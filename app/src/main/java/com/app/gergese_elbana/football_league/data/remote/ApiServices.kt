package com.app.gergese_elbana.football_league.data.remote

import com.app.gergese_elbana.football_league.data.remote.model.CompetitionsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("competitions")
    suspend fun getCompetitions():Response<CompetitionsResponse>
}