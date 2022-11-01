package com.alura.mobflix.ui.component

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alura.mobflix.R
import com.alura.mobflix.domain.model.VideoModel
import com.alura.mobflix.data.sampledata.sampleVideos
import com.alura.mobflix.ui.theme.MobFlixTheme

@Composable
fun HomeHighlight(
    video: VideoModel?,
    modifier: Modifier = Modifier
) {

    Box(
        modifier.fillMaxWidth()
            .heightIn(180.dp, 200.dp)
    ) {

        AsyncImage(
            model = "https://img.youtube.com/vi/${video?.url}/0.jpg",
            contentDescription = "Highlight thumbnail",
            placeholder = painterResource(R.drawable.videoplaceholder),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize(),
        )

        val context = LocalContext.current
        val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/${video?.url}")) }

        ValidateButton(
            label = "Watch now",
            onButtonClicked = { context.startActivity(intent) },
            Modifier.align(Alignment.BottomCenter)
        )

    }

}

@Preview
@Composable
private fun HomeHighlightPreview() {
    MobFlixTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            HomeHighlight(sampleVideos.first())

        }
    }
}