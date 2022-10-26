package com.alura.mobflix.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.alura.mobflix.R

@Composable
fun MobFlixAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier,
    ) {
        Text(
            text = "MOBFLIX",
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight(400),
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.primary,
            fontFamily = FontFamily(Font(R.font.bebasneue_book)),
            lineHeight = 38.sp
        )
    }
}
