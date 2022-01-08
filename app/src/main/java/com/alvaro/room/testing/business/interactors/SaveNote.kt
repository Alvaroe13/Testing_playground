package com.alvaro.room.testing.business.interactors

import com.alvaro.room.testing.business.domain.NoteApi
import com.alvaro.room.testing.framework.data.cache.NoteEntity
import com.alvaro.room.testing.business.util.ViewState
import kotlinx.coroutines.flow.flow

class SaveNote(
    private val databaseApi : NoteApi
) {

    fun execute(note : NoteEntity) = flow {

        emit(ViewState.Loading(isLoading = true))

        try {
            emit(ViewState.Success(databaseApi.saveNote(note =  note )))
        }catch (e :Exception){
            emit(ViewState.Error(message = e.localizedMessage ?: "Error something"))
        }
    }

}