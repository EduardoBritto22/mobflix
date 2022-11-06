package com.alura.mobflix.ui.screen

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alura.mobflix.domain.model.VideoModel
import com.alura.mobflix.ui.component.CategoryTagList
import com.alura.mobflix.ui.component.HomeHighlight
import com.alura.mobflix.ui.component.MobFlixAppBar
import com.alura.mobflix.ui.component.PreviewCard
import com.alura.mobflix.ui.navigation.Screen
import com.alura.mobflix.ui.theme.MobFlixTheme
import com.alura.mobflix.viewmodel.VideoViewModel
import com.alura.mobflix.viewmodel.VideosUiState

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeRoute(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: VideoViewModel = hiltViewModel(),
) {
    val uiState: VideosUiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        videosUiState = uiState,
        navController = navController,
        modifier
    )
}

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    videosUiState: VideosUiState,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            MobFlixAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(route = Screen.Register.route)
            }) {
                Icon(Icons.Filled.Add, "")
            }
        }
    ) { contentPadding ->

        when(videosUiState){
            VideosUiState.Loading -> {}
            VideosUiState.Error -> TODO()
            is VideosUiState.Success -> HomeScreenContent(
                modifier = modifier,
                contentPadding = contentPadding,
                videos = videosUiState.videos
            )
        }

    }
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier,
    contentPadding: PaddingValues,
    videos: List<VideoModel>
) {
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(contentPadding),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            HomeHighlight(videos.firstOrNull())
        }
        item {
            CategoryTagList()
        }

        items(videos) { video ->
            val context = LocalContext.current
            val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/${video.url}")) }

            PreviewCard(
                video,
                modifier = Modifier.padding(horizontal = 30.dp)
                    .clickable { context.startActivity(intent) }
            )
        }

        item {
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    MobFlixTheme {
        Surface {
            HomeRoute(rememberNavController())
        }
    }
}

@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun HomeScreenPreviewDarkMode() {
    MobFlixTheme {
        Surface {
            HomeRoute(rememberNavController())
        }
    }
}