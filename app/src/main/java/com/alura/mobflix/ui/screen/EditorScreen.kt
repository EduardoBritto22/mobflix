package com.alura.mobflix.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alura.domain.enum.VideoCategory
import com.alura.domain.model.VideoModel
import com.alura.mobflix.ui.component.CategoryChooser
import com.alura.mobflix.ui.component.TextInput
import com.alura.mobflix.ui.component.ValidateButton
import com.alura.mobflix.ui.theme.MobFlixTheme
import com.alura.mobflix.ui.theme.RedTag
import com.alura.mobflix.util.getAValidYoutubePath
import com.alura.mobflix.viewmodel.VideoUiState
import com.alura.mobflix.viewmodel.VideoViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun EditRoute(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: VideoViewModel = hiltViewModel(),
) {
    val uiState: VideoUiState by viewModel.singleVideoUiState.collectAsStateWithLifecycle()


    when (uiState) {
        VideoUiState.Loading -> EditorScreen(
            video = VideoModel(0, "", VideoCategory.MOBILE),
            navController = navController
        )

        VideoUiState.Error -> TODO()
        is VideoUiState.Success -> EditorScreen(
            video = (uiState as VideoUiState.Success).video,
            navController = navController,
            modifier = modifier
        )
    }

}


@Composable
fun EditorScreen(
    video: VideoModel,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: VideoViewModel = hiltViewModel()
) {

    Column(
        modifier = modifier
            .padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {

        var url: String by remember { mutableStateOf(video.url) }
        var category: VideoCategory by remember { mutableStateOf(video.category) }
        Text(
            "Edit the video",
            fontSize = 32.sp,
            fontWeight = FontWeight(700),
            lineHeight = 38.sp
        )

        TextInput(
            text = url,
            label = "URL",
            placeHolder = "Ex: https://youtu.be/N3h5A0oAzsk",
            onTextChange = { url = it }
        )

        CategoryChooser(
            { videoCategory ->
                category = videoCategory
            })

        VideoPreview(url, category)

        ValidateButton(
            label = "Update",
            onButtonClicked = {
                val validUrl = getAValidYoutubePath(url)
                video.url = validUrl
                video.category = category
                viewModel.updateVideo(video)
                navController.popBackStack()
            },
            Modifier.fillMaxWidth()
        )

        ValidateButton(
            label = "Delete",
            onButtonClicked = {
                viewModel.deleteVideo(video)
                navController.popBackStack()
            },
            Modifier.fillMaxWidth(),
            buttonColor = RedTag
        )

    }

}


@Preview(showSystemUi = true)
@Composable
private fun EditorScreenPreview() {
    MobFlixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            EditRoute(rememberNavController())
        }
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun EditorScreenPreviewDarkMode() {
    MobFlixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            EditRoute(rememberNavController())
        }
    }
}