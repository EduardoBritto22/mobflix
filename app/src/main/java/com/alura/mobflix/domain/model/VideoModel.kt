package com.alura.mobflix.domain.model

import com.alura.mobflix.domain.enum.VideoCategory

data class VideoModel(
    var id: Int,
    var url: String,
    var category: VideoCategory
)
