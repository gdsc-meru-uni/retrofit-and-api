package com.hcr.retro_and_api.presentation.screens

import com.hcr.retro_and_api.common.Resource
import com.hcr.retro_and_api.data.dto.PostResponseItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostUseCase
@Inject
constructor(
    private val repo: PostRepo
){
    operator fun invoke(): Flow<Resource<List<PostResponseItem>>> = flow {
        try {
            emit(Resource.Loading<List<PostResponseItem>>())

            val newsList = repo.getPost()

            emit(Resource.Success(newsList))

        }catch (e: HttpException){
            emit(Resource.Error<List<PostResponseItem>>(e.localizedMessage ?: "An unexpected error occurred"))

        }catch (e: IOException){
            emit(Resource.Error<List<PostResponseItem>>("Couldn't reach server. Check your internet connection."))
        }catch (e: Exception){
            emit(Resource.Error<List<PostResponseItem>>("Something unexpected happened. Please try again"))
        }
    }


}