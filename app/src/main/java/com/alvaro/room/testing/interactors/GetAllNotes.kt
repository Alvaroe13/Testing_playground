package com.alvaro.room.testing.interactors

import com.alvaro.room.testing.domain.cache.NoteCache
import com.alvaro.room.testing.util.ProgressBarState
import com.alvaro.room.testing.util.ViewState
import kotlinx.coroutines.flow.flow

class GetAllNotes(
    private val databaseCache : NoteCache
) {

    fun execute() = flow {

        emit(ViewState.Loading(progressBarState = ProgressBarState.Loading))
        try {
            emit(ViewState.Success(databaseCache.getAllNotes()))
        }catch (e :Exception){
            emit(ViewState.Error(message = e.localizedMessage ?: "Error something"))
        }finally{
            emit(ViewState.Loading(progressBarState = ProgressBarState.Idle))
        }

    }

}