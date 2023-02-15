package com.hcr.retro_and_api.presentation.screens

import com.hcr.retro_and_api.data.dto.PostResponseItem

data class PostState(
    val isLoading: Boolean? = false,
    val postList:List<PostResponseItem>? = emptyList(),
    val error: String? = null,
)