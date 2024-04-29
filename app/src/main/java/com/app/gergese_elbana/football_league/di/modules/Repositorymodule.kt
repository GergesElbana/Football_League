package com.app.gergese_elbana.football_league.di.modules

import com.app.gergese_elbana.football_league.data.repository.MainRepository
import org.koin.dsl.module

val repositoryModule= module {
    single {
            MainRepository(get())
    }
}