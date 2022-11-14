package com.alura.mobflix.data.sampledata

import com.alura.mobflix.domain.enum.VideoCategory
import com.alura.mobflix.domain.model.VideoModel

val sampleVideos = listOf(
    VideoModel(
        0,
        url = "LR5LUhTZPCE",
        category = VideoCategory.MOBILE
    ),
    VideoModel(
        1,
        url = "jK0uiQ1ZQQQ",
        category = VideoCategory.FRONT_ENT

    ),
    VideoModel(
        2,
        url = "1ERDjPlAA2A",
        category = VideoCategory.PROGRAMMING

    ),
    VideoModel(
        3,
        url = "ypvGqZGJBls",
        category = VideoCategory.MOBILE
    )
)