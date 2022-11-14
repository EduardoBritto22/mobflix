package com.alura.mobflix.domain.usecase

import com.alura.mobflix.domain.model.VideoModel
import com.alura.mobflix.domain.repository.IVideosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVideoByIdUseCase @Inject constructor(
    private val repository: IVideosRepository
) {
    operator fun invoke(id: Int): Flow<VideoModel> {
       return repository.getVideoById(id)
    }


}