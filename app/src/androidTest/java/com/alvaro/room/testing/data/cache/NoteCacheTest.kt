package com.alvaro.room.testing.data.cache

import com.alvaro.room.testing.domain.cache.NoteCache

class NoteCacheTest(
    private val dao: NoteDao
) : NoteCache {
    override suspend fun saveNote(note: NoteEntity): Long {
        return dao.insertNote(note)
    }

    override suspend fun getAllNotes(): List<NoteEntity> {
        return dao.getAllNotes()
    }
}