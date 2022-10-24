package com.alura.mobflix.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alura.mobflix.R
import com.alura.mobflix.enum.VideoTag
import com.alura.mobflix.ui.model.VideoModel

@Composable
fun PreviewCard(video: VideoModel) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        CategoryTag(video.category)
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            "Video preview",
            Modifier
                .heightIn(180.dp, 200.dp)
                .widthIn(320.dp, 350.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCardComponentPreview() {
    PreviewCard(
        VideoModel(
            category = VideoTag.MOBILE,
            url = ""
        )
    )
}
