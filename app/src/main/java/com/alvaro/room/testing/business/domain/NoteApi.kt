package com.alvaro.room.testing.business.domain

import com.alvaro.room.testing.framework.data.cache.NoteEntity

interface NoteApi {
    suspend fun saveNote(note : NoteEntity): Long
    suspend fun getAllNotes() : List<NoteEntity>
}