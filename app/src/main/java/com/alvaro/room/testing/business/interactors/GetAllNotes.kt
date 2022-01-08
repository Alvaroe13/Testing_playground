package com.alvaro.room.testing.business.interactors

import com.alvaro.room.testing.business.domain.NoteApi
import com.alvaro.room.testing.business.util.ViewState
import kotlinx.coroutines.flow.flow

class GetAllNotes(
    private val databaseApi : NoteApi
) {

    fun execute() = flow {

        emit(ViewState.Loading(isLoading = true))

        try {
            emit(ViewState.Success(databaseApi.getAllNotes()))
        }catch (e :Exception){
            emit(ViewState.Error(message = e.localizedMessage ?: "Error something"))
        }
    }

}