package com.hcr.retro_and_api.data
import com.hcr.retro_and_api.data.dto.PostResponseItem
import retrofit2.http.GET

interface PostResponseApi {

    //using multiple query
    @GET("photos")
    suspend fun getPost(): List<PostResponseItem>

}