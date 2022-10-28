package com.alura.mobflix.model

import com.alura.mobflix.enum.VideoCategory

data class VideoModel(
    var url: String,
    var category: VideoCategory
)
