package com.hcr.retro_and_api.data.di
import com.hcr.retro_and_api.data.PostResponseApi
import com.hcr.retro_and_api.presentation.screens.PostRepo
import com.hcr.retro_and_api.presentation.screens.PostRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun providePostResponseApi(): PostResponseApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostResponseApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRepo(api: PostResponseApi): PostRepo {
        return PostRepoImpl(api)
    }

}
