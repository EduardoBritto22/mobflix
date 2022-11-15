package com.alura.mobflix.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alura.domain.model.VideoModel
import com.alura.domain.model.result.Result
import com.alura.domain.model.result.asResult
import com.alura.domain.usecase.DeleteVideoUseCase
import com.alura.domain.usecase.GetVideoByIdUseCase
import com.alura.domain.usecase.SaveVideoUseCase
import com.alura.domain.usecase.UpdateVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleVideoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getVideoByIdUseCase: GetVideoByIdUseCase,
    private val saveVideoUseCase: SaveVideoUseCase,
    private val updateVideoUseCase: UpdateVideoUseCase,
    private val deleteVideoUseCase: DeleteVideoUseCase
) : ViewModel() {

    private val videoId: Int? =
        savedStateHandle["videoId"]


    val singleVideoUiState: StateFlow<VideoUiState> =
        getVideoByIdUseCase(videoId ?: 0).asResult()
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

    sealed interface VideoUiState {
        data class Success(val video: VideoModel) : VideoUiState
        object Error : VideoUiState
        object Loading : VideoUiState
    }

}
