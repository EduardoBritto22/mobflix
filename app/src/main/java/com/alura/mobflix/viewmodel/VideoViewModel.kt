package com.alura.mobflix.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alura.mobflix.domain.model.VideoModel
import com.alura.mobflix.domain.model.result.Result
import com.alura.mobflix.domain.model.result.asResult
import com.alura.mobflix.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getVideosUseCase: GetVideosUseCase,
    getVideoByIdUseCase: GetVideoByIdUseCase,
    private val saveVideoUseCase: SaveVideoUseCase,
    private val updateVideoUseCase: UpdateVideoUseCase,
    private val deleteVideoUseCase: DeleteVideoUseCase
) : ViewModel() {

    private val videoId: Int? =
        savedStateHandle["videoId"]



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

    val singleVideoUiState: StateFlow<VideoUiState> =
        getVideoByIdUseCase(videoId?:0).asResult()
            .map { result ->
                val videoUiState: VideoUiState = when (result) {
                    is Result.Success -> VideoUiState.Success(result.data)
                    is Result.Loading -> VideoUiState.Loading
                    is Result.Error -> VideoUiState.Error
                }
                videoUiState
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = VideoUiState.Loading
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

sealed interface VideoUiState {
    data class Success(val video: VideoModel) : VideoUiState
    object Error : VideoUiState
    object Loading : VideoUiState
}