package com.example.hbjracademy.domain.di

import com.example.hbjracademy.domain.use_case.GetGameDetailsUseCase
import com.example.hbjracademy.domain.use_case.GetGamesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetGamesUseCase(get()) }
    single { GetGameDetailsUseCase(get()) }
}
