package com.alura.mobflix.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alura.domain.enums.VideoCategory


@Composable
fun CategoryTagList(
    modifier: Modifier = Modifier,
    onTagClicked: (VideoCategory?) -> Unit = {}
) {
    var categoryState: VideoCategory? by remember { mutableStateOf(null) }
    var categories by remember { mutableStateOf(VideoCategory.values()) }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        items(categories) { category ->
            CategoryTag(
                category, modifier = Modifier.clickable {
                    categoryState = if (category == categoryState) {
                        null
                    } else {
                        category
                    }
                    categories =
                        VideoCategory.values()
                            .filterNot { categoryState != null && it != categoryState }
                            .toTypedArray()
                    onTagClicked(categoryState)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CategoryTagListPreview() {
    CategoryTagList()
}

