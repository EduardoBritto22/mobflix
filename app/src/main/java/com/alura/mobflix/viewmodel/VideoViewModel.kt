package com.alura.mobflix.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alura.mobflix.domain.model.VideoModel
import com.alura.mobflix.domain.usecase.DeleteVideoUseCase
import com.alura.mobflix.domain.usecase.GetVideosUseCase
import com.alura.mobflix.domain.usecase.SaveVideoUseCase
import com.alura.mobflix.domain.usecase.UpdateVideoUseCase
import com.alura.mobflix.domain.model.result.Result
import com.alura.mobflix.domain.model.result.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val getVideosUseCase: GetVideosUseCase,
    private val saveVideoUseCase: SaveVideoUseCase,
    private val updateVideoUseCase: UpdateVideoUseCase,
    private val deleteVideoUseCase: DeleteVideoUseCase
) : ViewModel() {

    val uiState: StateFlow<VideosUiState> =
        getVideosUseCase().asResult()
            .map { result ->
                val videosUiState: VideosUiState = when (result) {
                    is Result.Success -> VideosUiState.Success(result.data)
                    is Result.Loading -> VideosUiState.Loading
                    is Result.Error -> VideosUiState.Error
                }
                videosUiState
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = VideosUiState.Loading
            )

    fun saveVideo(videoModel: VideoModel) {
        viewModelScope.launch {
            saveVideoUseCase(videoModel)
        }
    }

    fun updateVideo(videoModel: VideoModel) {
        viewModelScope.launch {
            updateVideoUseCase(videoModel)
        }
    }

    fun deleteVideo(videoModel: VideoModel) {
        viewModelScope.launch {
            deleteVideoUseCase(videoModel)
        }
    }

}


sealed interface VideosUiState {
    data class Success(val videos: List<VideoModel>) : VideosUiState
    object Error : VideosUiState
    object Loading : VideosUiState
}