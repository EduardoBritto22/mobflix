package com.alura.mobflix.domain.usecase

import com.alura.mobflix.domain.model.VideoModel
import com.alura.mobflix.domain.repository.IVideosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateVideoUseCase @Inject constructor(
    private val repository: IVideosRepository
) {
    suspend operator fun invoke(videoModel: VideoModel)= withContext(Dispatchers.Default){
        repository.updateVideo(videoModel)
    }
}