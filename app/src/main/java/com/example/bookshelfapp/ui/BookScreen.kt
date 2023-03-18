package com.example.bookshelfapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelfapp.R


@Composable
fun BookShelfApp(
    bookUiState: BookUiState
){
    when(bookUiState){
        is BookUiState.Loading ->{}
        is BookUiState.Success -> BookShelfScreen(thumbnails = bookUiState.thumbnails)
        is BookUiState.Error ->{}
    }
}


@Composable
fun BookShelfScreen(
    modifier: Modifier = Modifier,
    thumbnails : List<String>
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ){
        items(thumbnails){
            thumbnail -> BookThumbNail(thumbnail = thumbnail)

        }
    }
}

@Composable
fun BookThumbNail(
    modifier: Modifier = Modifier,
    thumbnail : String
){
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .aspectRatio(9f/16f),
        elevation = 8.dp,
    ){
        AsyncImage(

            model = ImageRequest.Builder(context = LocalContext.current)
                .data(thumbnail)
                .crossfade(true)
                .build(),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}