package com.example.hbjracademy.repository.di

import com.example.hbjracademy.domain.repository.GameDetailsRepository
import com.example.hbjracademy.domain.repository.GamesRepository
import com.example.hbjracademy.repository.data_source.GameDetailsRepositoryImpl
import com.example.hbjracademy.repository.data_source.GamesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GamesRepository> { GamesRepositoryImpl(get()) }
    single<GameDetailsRepository> { GameDetailsRepositoryImpl(get()) }
}