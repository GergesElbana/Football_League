package com.app.gergese_elbana.football_league.di.modules

import com.app.gergese_elbana.football_league.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules= module {
    viewModel { MainViewModel(get()) }
}