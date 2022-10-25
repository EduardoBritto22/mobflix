package com.alura.mobflix.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alura.mobflix.model.VideoModel
import com.alura.mobflix.sampledata.sampleVideos
import com.alura.mobflix.ui.component.CategoryTagList
import com.alura.mobflix.ui.component.HomeHighlight
import com.alura.mobflix.ui.component.PreviewCard
import com.alura.mobflix.ui.theme.MobFlixTheme

@Composable
fun HomeScreen(videos: List<VideoModel>,highlightVideo: VideoModel) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {

        HomeHighlight(highlightVideo)

        CategoryTagList()

        LazyColumn(
            Modifier.fillMaxSize()
                .padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            items(videos){video->
                PreviewCard(video)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    MobFlixTheme {
        Surface {
            HomeScreen(sampleVideos, sampleVideos.first())
        }
    }
}