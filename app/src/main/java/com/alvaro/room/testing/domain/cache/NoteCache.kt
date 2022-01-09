package com.alvaro.room.testing.domain.cache

import com.alvaro.room.testing.data.cache.NoteEntity

interface NoteCache {
    suspend fun saveNote(note : NoteEntity): Long
    suspend fun getAllNotes() : List<NoteEntity>
}