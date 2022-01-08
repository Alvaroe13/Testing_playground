package com.alvaro.room.testing.data.local

import com.alvaro.room.testing.business.domain.NoteApi
import com.alvaro.room.testing.framework.data.cache.NoteDao
import com.alvaro.room.testing.framework.data.cache.NoteEntity

class NoteApiTest(
    private val dao: NoteDao
) : NoteApi {
    override suspend fun saveNote(note: NoteEntity): Long {
        return dao.insertNote(note)
    }

    override suspend fun getAllNotes(): List<NoteEntity> {
        return dao.getAllNotes()
    }
}