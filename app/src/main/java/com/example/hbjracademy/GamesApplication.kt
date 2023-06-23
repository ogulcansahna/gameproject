package com.example.hbjracademy

import android.app.Application
import com.example.hbjracademy.di.presentationModule
import com.example.hbjracademy.domain.di.domainModule
import com.example.hbjracademy.network.di.networkModule
import com.example.hbjracademy.repository.di.repositoryModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class GamesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        val modules = listOf(domainModule, networkModule, repositoryModule, presentationModule)
        startKoin {
            androidLogger(level = Level.NONE)
            androidContext(this@GamesApplication)
            modules(modules)
        }
    }
}