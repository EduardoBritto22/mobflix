package com.alura.mobflix.data.repository.datasource

import com.alura.mobflix.data.db.entity.VideoEntity
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {
    fun getVideos(): Flow<List<VideoEntity>>
    suspend fun saveVideo(videoEntity: VideoEntity)
    suspend fun updateVideo(videoEntity: VideoEntity)
    suspend fun deleteVideo(videoEntity: VideoEntity)
}