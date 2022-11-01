package com.alura.mobflix.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alura.mobflix.domain.enum.VideoCategory

@Composable
fun CategoryTag(
    tag: VideoCategory,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Box(Modifier.background(color = tag.color)) {
            Text(
                tag.tagName,
                Modifier.padding(horizontal = 20.dp, vertical = 7.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryTagPreview() {
    CategoryTag(VideoCategory.MOBILE)
}