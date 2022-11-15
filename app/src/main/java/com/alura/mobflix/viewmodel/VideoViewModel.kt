package com.alura.mobflix.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alura.domain.model.VideoModel
import com.alura.domain.model.result.Result
import com.alura.domain.model.result.asResult
import com.alura.domain.usecase.GetVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    getVideosUseCase: GetVideosUseCase
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



}


sealed interface VideosUiState {
    data class Success(val videos: List<VideoModel>) : VideosUiState
    object Error : VideosUiState
    object Loading : VideosUiState
}
