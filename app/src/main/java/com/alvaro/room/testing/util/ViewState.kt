package com.alvaro.room.testing.util

/* not ViewState as in MVI, just a whatever name I chose */
sealed class ViewState<out T> {

    data class Success<out T>( val data: T) : ViewState<T>()

    data class Error(val message: String) : ViewState<Nothing>()

    data class Loading(
        val progressBarState: ProgressBarState = ProgressBarState.Idle
    ) : ViewState<Nothing>()
}

sealed class ProgressBarState{
    object Loading: ProgressBarState()
    object Idle: ProgressBarState()
}