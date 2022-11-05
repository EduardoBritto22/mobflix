package com.alura.mobflix.data.repository.datasourceimpl

import com.alura.mobflix.data.db.VideosDao
import com.alura.mobflix.data.db.entity.VideoEntity
import com.alura.mobflix.data.repository.datasource.ILocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val videosDao: VideosDao): ILocalDataSource {
    override suspend fun getVideos(): Flow<List<VideoEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveVideo(videoEntity: VideoEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun updateVideo(videoEntity: VideoEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteVideo(videoEntity: VideoEntity) {
        TODO("Not yet implemented")
    }
}