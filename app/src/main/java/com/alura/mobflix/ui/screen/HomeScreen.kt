package com.alura.mobflix.ui.screen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alura.mobflix.model.VideoModel
import com.alura.mobflix.sampledata.sampleVideos
import com.alura.mobflix.ui.component.CategoryTagList
import com.alura.mobflix.ui.component.HomeHighlight
import com.alura.mobflix.ui.component.MobFlixAppBar
import com.alura.mobflix.ui.component.PreviewCard
import com.alura.mobflix.ui.navigation.Screen
import com.alura.mobflix.ui.theme.MobFlixTheme

@Composable
fun HomeScreen(
    videos: List<VideoModel>,
    navController: NavController,
    highlightVideo: VideoModel?
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

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(contentPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                HomeHighlight(highlightVideo)
            }
            item {
                CategoryTagList()
            }

            items(videos) { video ->
                PreviewCard(
                    video,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )
            }

            item {
                Spacer(Modifier
                    .fillMaxWidth()
                    .height(20.dp))
            }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    MobFlixTheme {
        Surface {
            HomeScreen(sampleVideos,rememberNavController(), sampleVideos.first())
        }
    }
}

@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun HomeScreenPreviewDarkMode() {
    MobFlixTheme {
        Surface {
           HomeScreen(sampleVideos,rememberNavController(), sampleVideos.first())
        }
    }
}