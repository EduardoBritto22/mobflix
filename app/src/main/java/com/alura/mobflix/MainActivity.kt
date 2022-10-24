package com.alura.mobflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.alura.mobflix.enum.VideoTag
import com.alura.mobflix.ui.component.PreviewCard
import com.alura.mobflix.ui.model.VideoModel
import com.alura.mobflix.ui.theme.MobFlixTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobFlixTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PreviewCard(VideoModel(
                        category = VideoTag.MOBILE,
                        url = "LR5LUhTZPCE"
                    ))
                }
            }
        }
    }
}
