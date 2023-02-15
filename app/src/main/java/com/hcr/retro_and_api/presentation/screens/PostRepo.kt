package com.hcr.retro_and_api.presentation.screens

import com.hcr.retro_and_api.data.dto.PostResponseItem

interface PostRepo {

    suspend fun getPost(): List<PostResponseItem>


}