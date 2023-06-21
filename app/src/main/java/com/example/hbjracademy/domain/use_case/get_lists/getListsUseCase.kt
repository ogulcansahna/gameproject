package com.example.hbjracademy.domain.use_case.get_lists

import com.example.hbjracademy.common.Resource
import com.example.hbjracademy.data.remote.dto.toGame
import com.example.hbjracademy.domain.model.Games
import com.example.hbjracademy.domain.repository.gamesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class getListsUseCase @Inject constructor(
    private val repository: gamesRepository
) {
    operator fun invoke():Flow<Resource<List<Games>>> = flow {
        try {
            emit(Resource.Loading())
            val game = repository.getGames().map { it.toGame() }
            emit(Resource.Success(game))
        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage ?:"Unexpected Error Occured"))
        }catch (e:IOException){
            emit(Resource.Error("Check Your Connection"))
        }
    }


}