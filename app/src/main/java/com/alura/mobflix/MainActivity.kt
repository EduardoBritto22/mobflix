package com.alura.mobflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alura.mobflix.enum.VideoTag
import com.alura.mobflix.ui.theme.MobFlixTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobFlixTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

@Composable
fun TagComponent(tag: VideoTag) {
    Surface(shape = RoundedCornerShape(12.dp) ) {
        Box(Modifier.background(color = tag.color)) {
            Text(
                tag.tagName,
                Modifier.padding(horizontal = 22.dp, vertical = 7.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = Color.White
            )
        }
    }
}
@Composable
fun TagListComponent() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(VideoTag.values()){ category ->
            TagComponent(category)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TagComponentPreview() {
    TagComponent(VideoTag.MOBILE)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TagListComponentPreview() {
    TagListComponent()
}
