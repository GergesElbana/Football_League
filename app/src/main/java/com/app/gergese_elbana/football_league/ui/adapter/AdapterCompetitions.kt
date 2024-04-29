package com.app.gergese_elbana.football_league.ui.adapter

import com.app.gergese_elbana.football_league.base.BaseAdapter
import com.app.gergese_elbana.football_league.base.BaseInteractionListener
import com.app.gergese_elbana.football_league.data.remote.model.CompetitionsResponse
import com.example.football_league.R

class AdapterCompetitions(
    competitionList: ArrayList<CompetitionsResponse.Competition>,
    listener: CompetitionListener
) : BaseAdapter<CompetitionsResponse.Competition>(competitionList, listener) {
    override var layoutId: Int = R.layout.item_competitions

    interface CompetitionListener : BaseInteractionListener {

    }
}