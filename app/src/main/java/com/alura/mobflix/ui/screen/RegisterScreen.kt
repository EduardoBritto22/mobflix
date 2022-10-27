package com.alura.mobflix.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alura.mobflix.model.VideoModel
import com.alura.mobflix.ui.component.PreviewCard
import com.alura.mobflix.ui.component.TextInput
import com.alura.mobflix.ui.component.ValidateButton
import com.alura.mobflix.ui.theme.MobFlixTheme

@Composable
fun RegisterScreen() {

    Column(
        modifier = Modifier
            .padding(36.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {

        var video: VideoModel? = null

        Text(
            "Register a video",
            fontSize = 32.sp,
            fontWeight = FontWeight(700),
            lineHeight = 38.sp
        )

        TextInput("URL","Ex: N3h5A0oAzsk")

        TextInput("Category","Mobile, Front End, etc")

        PreviewCard(video)

        ValidateButton(
            label = "Register",
            onButtonClicked = {},
            Modifier.fillMaxWidth()
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