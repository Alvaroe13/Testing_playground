package com.alvaro.room.testing.interactors

import com.alvaro.room.testing.domain.cache.NoteCache
import com.alvaro.room.testing.data.cache.NoteEntity
import com.alvaro.room.testing.util.ProgressBarState
import com.alvaro.room.testing.util.ViewState
import kotlinx.coroutines.flow.flow

class SaveNote(
    private val noteCache: NoteCache
) {

    fun execute(note: NoteEntity) = flow {

        emit(ViewState.Loading(progressBarState = ProgressBarState.Loading))
        try {

            noteCache.insertNote(note = note)

            emit(ViewState.Success(MSG_SUCCESS))
        } catch (e: Exception) {
            emit(ViewState.Error(message = e.localizedMessage ?: MSG_ERROR))
        } finally {
            emit(ViewState.Loading(progressBarState = ProgressBarState.Idle))
        }

    }

    companion object {
        const val MSG_SUCCESS= "Added note successfully"
        const val MSG_ERROR= "Error inserting note"
    }

}