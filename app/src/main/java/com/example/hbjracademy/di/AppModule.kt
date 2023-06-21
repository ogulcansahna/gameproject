package com.example.hbjracademy.di
import com.example.hbjracademy.common.Constants
import com.example.hbjracademy.data.remote.gamesApi
import com.example.hbjracademy.data.repository.gamesRepositoryImpl
import com.example.hbjracademy.domain.repository.gamesRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
//@InstallIn(SingletonComponent::class)

object AppModule {
    @Provides
    @Singleton
    fun provideGamesApi():gamesApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(gamesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGamesRepository(api: gamesApi):gamesRepository{
        return gamesRepositoryImpl(api)
    }
}