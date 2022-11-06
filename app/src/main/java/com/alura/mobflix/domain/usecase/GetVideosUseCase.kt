package com.alura.mobflix.domain.usecase

import com.alura.mobflix.domain.model.VideoModel
import com.alura.mobflix.domain.repository.IVideosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetVideosUseCase @Inject constructor(
    private val repository: IVideosRepository
) {
    suspend operator fun invoke(): Flow<List<VideoModel>> = withContext(Dispatchers.Default) {
        repository.getVideos()
    }


}