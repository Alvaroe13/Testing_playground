package com.alvaro.room.testing.interactors

import com.alvaro.room.testing.data.cache.NoteCacheFake
import com.alvaro.room.testing.data.cache.NoteDatabaseFake
import com.alvaro.room.testing.data.cache.NoteEntity
import com.alvaro.room.testing.util.ProgressBarState
import com.alvaro.room.testing.util.ViewState
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

/**
 * 1. Success insert note
 */
class SaveNoteTest {

    //system in test
    private lateinit var saveNote: SaveNote

    //dependency for system in test
    private lateinit var noteCacheFake: NoteCacheFake

    @Before
    fun setup() {
        val databaseFake = NoteDatabaseFake()
        noteCacheFake = NoteCacheFake(database = databaseFake)
        saveNote = SaveNote(
            noteCache = noteCacheFake
        )
    }

    @Test
    fun `insert note Success`() = runBlocking {

        val notesInCache = noteCacheFake.getAllNotes()

        //check list is loaded properly
        assert(notesInCache.isNotEmpty())

        //execute use-case
        val note = NoteEntity(
            id = Random.nextInt().toString(),
            title = Random.nextInt().toString(),
            body = Random.nextInt().toString(),
            priority = Random.nextInt().toString(),
        )
        val emissions = saveNote.execute(note = note).toList()

        //confirm pb state is loading
        assert(emissions[0] == ViewState.Loading(progressBarState = ProgressBarState.Loading))

        //confirm no error thrown when added new note
        assert(emissions[1] is ViewState.Success)

        // check that indeed such note now it's in the cache
       /* val listUpdated = noteCacheFake.getAllNotes()
        println("TAGTAG size ${listUpdated.size} , size 2 ${notesInCache.size}")
        assert(listUpdated.size == notesInCache.size + 1)*/

        //confirms pb state is idle
        assert(emissions[2] == ViewState.Loading(progressBarState = ProgressBarState.Idle))
    }
}