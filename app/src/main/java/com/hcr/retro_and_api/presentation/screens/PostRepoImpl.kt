package com.hcr.retro_and_api.presentation.screens

import com.hcr.retro_and_api.data.PostResponseApi
import com.hcr.retro_and_api.data.dto.PostResponseItem
import javax.inject.Inject

class PostRepoImpl
    @Inject
        constructor(
        private val api: PostResponseApi
): PostRepo {

    override suspend fun getPost():  List<PostResponseItem> {
        return api.getPost()
    }
}