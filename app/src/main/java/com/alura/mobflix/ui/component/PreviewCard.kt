package com.alura.mobflix.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alura.mobflix.R
import com.alura.mobflix.domain.enum.VideoCategory
import com.alura.mobflix.domain.model.VideoModel
import com.alura.mobflix.util.getAValidYoutubePath

@Composable
fun PreviewCard(
    video: VideoModel,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxWidth()
            .heightIn(min = 180.dp, max = 200.dp),
    ) {

        var showCategory by remember { mutableStateOf(false) }

        if (showCategory) {
            CategoryTag(video.category)
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
        ) {

            val validUrl = getAValidYoutubePath(video.url)

            AsyncImage(
                model = "https://img.youtube.com/vi/${validUrl}/0.jpg",
                contentDescription = "Video preview",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.videoplaceholder),
                onSuccess = { showCategory = true },
                onError = { showCategory = false},
                error = painterResource(R.drawable.videoplaceholder)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCardComponentPreview() {
    PreviewCard(
        VideoModel(
            category = VideoCategory.MOBILE,
            url = "LR5LUhTZPCE"
        )
    )
}
