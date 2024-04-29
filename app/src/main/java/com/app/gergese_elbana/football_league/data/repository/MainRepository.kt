package com.app.gergese_elbana.football_league.data.repository

import com.app.gergese_elbana.football_league.data.remote.ApiServices
import com.app.gergese_elbana.football_league.data.remote.network.NetworkResult

class MainRepository(private val apiServices: ApiServices):NetworkResult() {

    suspend fun getCompetitions()=checkResult({apiServices.getCompetitions()})

}