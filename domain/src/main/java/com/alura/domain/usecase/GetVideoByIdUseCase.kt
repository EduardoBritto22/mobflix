package com.alura.domain.usecase

import com.alura.domain.model.VideoModel
import com.alura.domain.repository.IVideosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVideoByIdUseCase @Inject constructor(
    private val repository: IVideosRepository
) {
    operator fun invoke(id: Int): Flow<VideoModel> {
       return repository.getVideoById(id)
    }


}