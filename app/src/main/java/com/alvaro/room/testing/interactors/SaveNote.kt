package com.alvaro.room.testing.interactors

import com.alvaro.room.testing.domain.cache.NoteCache
import com.alvaro.room.testing.data.cache.NoteEntity
import com.alvaro.room.testing.util.ProgressBarState
import com.alvaro.room.testing.util.ViewState
import kotlinx.coroutines.flow.flow

class SaveNote(
    private val databaseCache : NoteCache
) {

    fun execute(note : NoteEntity) = flow {

        emit(ViewState.Loading(progressBarState = ProgressBarState.Loading))
        try {
            emit(ViewState.Success(databaseCache.saveNote(note =  note )))
        }catch (e :Exception){
            emit(ViewState.Error(message = e.localizedMessage ?: "Error something"))
        }finally{
            emit(ViewState.Loading(progressBarState = ProgressBarState.Idle))
        }

    }

}