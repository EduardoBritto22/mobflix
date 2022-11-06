package com.alura.mobflix.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alura.mobflix.domain.model.VideoModel
import com.alura.mobflix.domain.usecase.DeleteVideoUseCase
import com.alura.mobflix.domain.usecase.GetVideosUseCase
import com.alura.mobflix.domain.usecase.SaveVideoUseCase
import com.alura.mobflix.domain.usecase.UpdateVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val getVideosUseCase: GetVideosUseCase,
    private val saveVideoUseCase: SaveVideoUseCase,
    private val updateVideoUseCase: UpdateVideoUseCase,
    private val deleteVideoUseCase: DeleteVideoUseCase
) : ViewModel() {

    var videos : Flow<List<VideoModel>> = emptyFlow()

    fun getVideos(){
        viewModelScope.launch {
            videos = getVideosUseCase()
        }
    }

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