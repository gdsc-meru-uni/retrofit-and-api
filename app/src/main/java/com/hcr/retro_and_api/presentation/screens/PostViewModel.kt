package com.hcr.retro_and_api.presentation.screens
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hcr.retro_and_api.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PostViewModel
@Inject
constructor(
    private val useCase: PostUseCase
): ViewModel(){

    private val _postState = mutableStateOf(PostState())
    val postState: State<PostState> = _postState


    private fun getPost(){
        viewModelScope.launch {

            useCase.invoke().collect{ response ->

                when(response){
                    is Resource.Loading -> {
                        _postState.value = PostState(isLoading = true)

                    }
                    is Resource.Success -> {
                        _postState.value = PostState(postList = response.data)
                        Log.d("viewModel", response.data.toString())

                        println(response.data)
                    }
                    is Resource.Error -> {
                        _postState.value = PostState(error = response.errorMessage.toString())

                        println(response.errorMessage)

                    }
                }


            }
        }
    }
}