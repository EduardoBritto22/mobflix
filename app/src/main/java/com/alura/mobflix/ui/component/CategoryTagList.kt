package com.alura.mobflix.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alura.mobflix.domain.enum.VideoCategory


@Composable
fun CategoryTagList(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        items(VideoCategory.values()) { category ->
            CategoryTag(category)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CategoryTagListPreview() {
    CategoryTagList()
}

