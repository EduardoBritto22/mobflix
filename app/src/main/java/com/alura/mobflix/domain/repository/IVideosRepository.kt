package com.alura.mobflix.domain.repository

import com.alura.mobflix.domain.model.VideoModel
import kotlinx.coroutines.flow.Flow

interface IVideosRepository{

    fun getVideos(): Flow<List<VideoModel>>
    suspend fun saveVideo(video: VideoModel)
    suspend fun updateVideo(video: VideoModel)
    suspend fun deleteVideo(video: VideoModel)

}