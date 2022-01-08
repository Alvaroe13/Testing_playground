package com.alvaro.room.testing.business.data.cache

import com.alvaro.room.testing.framework.data.cache.NoteDao
import com.alvaro.room.testing.framework.data.cache.NoteEntity
import com.alvaro.room.testing.business.domain.NoteApi

class NoteApiImpl(
    private val dao : NoteDao
) : NoteApi {
    override suspend fun saveNote(note: NoteEntity): Long {
       return dao.insertNote(note)
    }

    override suspend fun getAllNotes(): List<NoteEntity> {
        return dao.getAllNotes()
    }
}