package com.example.hbjracademy.di

import com.example.hbjracademy.ui.screens.games_detail.GameDetailsViewModel
import com.example.hbjracademy.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { GameDetailsViewModel(get()) }
}

val loadPresentationModule by lazy {
    val modules = listOf(presentationModule)
    loadKoinModules(modules)
}