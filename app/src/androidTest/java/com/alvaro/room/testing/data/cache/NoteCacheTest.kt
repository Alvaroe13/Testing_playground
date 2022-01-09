package com.alvaro.room.testing.data.cache

import com.alvaro.room.testing.domain.cache.NoteCache

class NoteCacheTest(
    private val dao: NoteDao
) : NoteCache {
    override suspend fun insertNote(note: NoteEntity) {
        dao.insertNote(note)
    }

    override suspend fun getAllNotes(): List<NoteEntity> {
        return dao.getAllNotes()
    }

    override suspend fun deleteNote(note: NoteEntity) {
        dao.deleteNote(note)
    }

    override suspend fun updateNote(note: NoteEntity) {
      dao.updateNote(note)
    }

    override suspend fun getNoteById(noteId: String): NoteEntity? {
        return dao.getNoteById(noteId)
    }

    override suspend fun insertNotes(notes: List<NoteEntity>) {
        dao.insertNotes(notes)
    }
}