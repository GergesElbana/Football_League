package com.app.gergese_elbana.football_league.ui


import com.app.gergese_elbana.football_league.base.BaseActivity
import com.app.gergese_elbana.football_league.ui.adapter.AdapterCompetitions
import com.app.gergese_elbana.football_league.ui.viewmodel.MainViewModel
import com.example.football_league.R
import com.example.football_league.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(), AdapterCompetitions.CompetitionListener {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var adapterCompetitions: AdapterCompetitions
    override fun layoutId(): Int = R.layout.activity_main

    override fun initUi() {
        binding.viewModel = mainViewModel
        adapterCompetitions = AdapterCompetitions(arrayListOf(), this)
        binding.rvCompetition.adapter = adapterCompetitions

    }

    override fun addApiCall() {
        mainViewModel.getCompetition()
    }

    override fun setUpClicks() {

    }

    override fun observer() {

    }


}