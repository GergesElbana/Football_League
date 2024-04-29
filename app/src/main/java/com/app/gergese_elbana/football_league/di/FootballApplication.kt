package com.app.gergese_elbana.football_league.di

import android.app.Application
import com.app.gergese_elbana.football_league.di.modules.networkModule
import com.app.gergese_elbana.football_league.di.modules.repositoryModule
import com.app.gergese_elbana.football_league.di.modules.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class FootballApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@FootballApplication)
            modules(listOf(networkModule, repositoryModule, viewModelModules))
        }
    }
}