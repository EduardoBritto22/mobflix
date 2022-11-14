package com.alura.domain.usecase

import com.alura.domain.model.VideoModel
import com.alura.domain.repository.IVideosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveVideoUseCase @Inject constructor(
    private val repository: IVideosRepository
) {
    suspend operator fun invoke(videoModel: VideoModel)= withContext(Dispatchers.Default){
        repository.saveVideo(videoModel)
    }
}