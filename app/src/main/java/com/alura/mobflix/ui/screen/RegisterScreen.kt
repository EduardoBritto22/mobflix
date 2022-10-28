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
import com.alura.mobflix.enum.VideoCategory
import com.alura.mobflix.model.VideoModel
import com.alura.mobflix.ui.component.CategoryChooser
import com.alura.mobflix.ui.component.PreviewCard
import com.alura.mobflix.ui.component.TextInput
import com.alura.mobflix.ui.component.ValidateButton
import com.alura.mobflix.ui.theme.MobFlixTheme
import com.alura.mobflix.util.getAValidYoutubePath

@Composable
fun RegisterScreen() {

    Column(
        modifier = Modifier
            .padding(36.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {

        var url: String by remember { mutableStateOf("") }
        var category: VideoCategory by remember { mutableStateOf(VideoCategory.MOBILE) }
        Text(
            "Register a video",
            fontSize = 32.sp,
            fontWeight = FontWeight(700),
            lineHeight = 38.sp
        )

        TextInput(
            text = url,
            label = "URL",
            placeHolder = "Ex: N3h5A0oAzsk",
            onTextChange = { url = it }
        )

        CategoryChooser(
            { videoCategory ->
                category = videoCategory
            })

        VideoPreview(url, category)

        ValidateButton(
            label = "Register",
            onButtonClicked = {
                val validUrl = getAValidYoutubePath(url)
                VideoModel(
                    url = validUrl,
                    category = category
                )
            },
            Modifier.fillMaxWidth()
        )
    }

}

@Composable
fun VideoPreview(url: String, category: VideoCategory) {
    Column {

        Text(
            "Preview",
            Modifier.padding(bottom = 13.dp),
            fontSize = 28.sp,
            fontWeight = FontWeight(700),
            lineHeight = 33.sp
        )

        PreviewCard(
            VideoModel(
                url,
                category
            )
        )
    }
}


@Preview(showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    MobFlixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            RegisterScreen()
        }
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun RegisterScreenPreviewDarkMode() {
    MobFlixTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            RegisterScreen()
        }
    }
}