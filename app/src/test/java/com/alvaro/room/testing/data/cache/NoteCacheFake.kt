package com.alvaro.room.testing.data.cache

import com.alvaro.room.testing.domain.cache.NoteCache

class NoteCacheFake(
    private val database: NoteDatabaseFake
) : NoteCache {

    override suspend fun insertNote(note: NoteEntity) {
        if (database.notes.contains(note)) {
            database.notes.remove(note)
        }
        database.notes.add(note)
    }

    override suspend fun getAllNotes(): List<NoteEntity> {
        return database.notes
    }

    override suspend fun deleteNote(note: NoteEntity) {
        if (!database.notes.contains(note)) {
            throw Exception(ERROR_DELETE)
        }
        database.notes.remove(note)
    }

    override suspend fun updateNote(note: NoteEntity) {
        if (!database.notes.contains(note)) {
            throw Exception(ERROR_UPDATE)
        }
        database.notes.add(note)
    }

    override suspend fun getNoteById(noteId: String): NoteEntity? {
        var noteRetrieved: NoteEntity? = null
        database.notes.forEach { note ->
            if (note.id == noteId) {
                noteRetrieved = note
            }
        }
        noteRetrieved ?: throw Exception(ERROR_NOTE_NOT_FOUND)

        return noteRetrieved
    }

    override suspend fun insertNotes(notes: List<NoteEntity>) {
        database.notes.addAll(notes)
    }

    companion object ExceptionsMsg {
        const val ERROR_DELETE = "Note is not in database so it can't be deleted"
        const val ERROR_UPDATE = "Note is not in database so it can't be updated"
        const val ERROR_NOTE_NOT_FOUND = "Note search by Id not found"
    }
}