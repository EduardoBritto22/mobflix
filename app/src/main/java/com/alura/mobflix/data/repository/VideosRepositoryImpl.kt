package com.alura.mobflix.data.repository

import com.alura.mobflix.data.db.entity.VideoEntity
import com.alura.mobflix.data.mapper.Mapper
import com.alura.mobflix.data.repository.datasource.ILocalDataSource
import com.alura.mobflix.domain.model.VideoModel
import com.alura.mobflix.domain.repository.IVideosRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VideosRepositoryImpl @Inject constructor(
    private val localDataSource: ILocalDataSource,
    private val mapper: Mapper<VideoEntity, VideoModel>
) : IVideosRepository {

    override suspend fun getVideos(): Flow<List<VideoModel>> {
        return localDataSource.getVideos().map { videoList -> videoList.map(mapper::mapFromEntity) }
    }

    override suspend fun saveVideo(video: VideoModel) {
        localDataSource.saveVideo(mapper.mapToEntity(video))
    }

    override suspend fun updateVideo(video: VideoModel) {
        localDataSource.updateVideo(mapper.mapToEntity(video))
    }

    override suspend fun deleteVideo(video: VideoModel) {
        localDataSource.deleteVideo(mapper.mapToEntity(video))
    }
}