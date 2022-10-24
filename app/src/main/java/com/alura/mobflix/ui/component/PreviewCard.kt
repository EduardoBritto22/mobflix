package com.alura.mobflix.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alura.mobflix.R
import com.alura.mobflix.enum.VideoTag
import com.alura.mobflix.ui.model.VideoModel

@Composable
fun PreviewCard(
    video: VideoModel,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        CategoryTag(video.category)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://img.youtube.com/vi/${video.url}/0.jpg")
                .crossfade(true)
                .build(),
            "Video preview",
            Modifier
                .heightIn(180.dp, 200.dp)
                .widthIn(320.dp, 350.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.videoplaceholder)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCardComponentPreview() {
    PreviewCard(
        VideoModel(
            category = VideoTag.MOBILE,
            url = "LR5LUhTZPCE"
        )
    )
}
