package com.hcr.retro_and_api.presentation.screens
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hcr.retro_and_api.data.dto.PostResponseItem
import com.hcr.retro_and_api.R


@Composable
fun HomeScreen() {

    val viewModel: PostViewModel = hiltViewModel()
    val state = viewModel.postState.value

    Log.d("home", state.postList.toString())
    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            contentPadding = PaddingValues(start = 4.dp, end = 4.dp, top = 15.dp, bottom = 70.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {

            state.postList?.let {
                items(it) { item ->
                   HomeListItem(itemModel = item)
                }
            }

        }


        //show error if any
        if (state.error?.isNotBlank() == true) {
            Text(
                text = state.error.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .align(Alignment.TopCenter)
            )
        }

        //load shimmer
        if (state.isLoading == true) {
           CircularProgressIndicator()
        }
    }



}







@Composable
fun HomeListItem(
    itemModel: PostResponseItem
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(itemModel.url)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "newsImage",
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .width(180.dp)
                .height(125.dp),
            contentScale = ContentScale.FillBounds,
            fallback = painterResource(id = R.drawable.ic_launcher_foreground)
        )

        
        Column {
            Text(text = itemModel.title)
            
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = itemModel.id.toString())
                Text(text = itemModel.albumId.toString())
            }
        }
    }
}