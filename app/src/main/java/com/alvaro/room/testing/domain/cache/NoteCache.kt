package com.alvaro.room.testing.domain.cache

import com.alvaro.room.testing.data.cache.NoteEntity

interface NoteCache {
    suspend fun insertNote(note : NoteEntity)
    suspend fun getAllNotes() : List<NoteEntity>
    suspend fun deleteNote(note: NoteEntity)
    suspend fun updateNote(note: NoteEntity)
    suspend fun getNoteById(noteId: String): NoteEntity?
    suspend fun insertNotes(notes: List<NoteEntity>)
}