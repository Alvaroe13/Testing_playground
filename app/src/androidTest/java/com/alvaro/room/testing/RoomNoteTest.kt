package com.alvaro.room.testing

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.alvaro.room.testing.framework.data.cache.NoteDao
import com.alvaro.room.testing.framework.data.cache.NoteDatabase
import com.alvaro.room.testing.framework.data.cache.NoteEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random


/**
 * 1. Success insert new note
 */
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class RoomNoteTest {

    private lateinit var database: NoteDatabase
    private lateinit var dao: NoteDao

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDatabase::class.java,
        ).allowMainThreadQueries().build()

        dao = database.getNoteDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertNewNote_Success() = runBlocking {
        val note = NoteEntity(
            title = "Spiderman ticket",
            body = "Buy Spiderman tickets",
            id = 1,
            priority = 5
        )

        //confirm db is empty
        val notes = dao.getAllNotes()
        assert(notes.isEmpty())

        //Insert new now
        dao.insertNote(note = note)

        //confirm note has been added
        val noteList = dao.getAllNotes()
        assert(noteList.isNotEmpty())
        assert(noteList.size == 1)
    }

    @Test
    fun getNoteById_Success() = runBlocking {
        val note = NoteEntity(
            title = "Spiderman ticket",
            body = "Buy Spiderman tickets",
            id = Random.nextInt(),
            priority = 5
        )

        //confirm db is empty
        val notes = dao.getAllNotes()
        assert(notes.isEmpty())

        //Insert new now
        dao.insertNote(note = note)

        //confirm the same note added has been retrieved
        val noteRetrieved = dao.getNoteById(noteId = note.id)
        println("note id = ${note.id}, retreived note id= ${noteRetrieved.id}")
        assert(noteRetrieved.id == note.id)
    }


    @Test
    fun insertNoteList_Success() = runBlocking {

        val noteList = mutableListOf<NoteEntity>()

        for (i in 1 until 10) {
            noteList.add(
                NoteEntity(
                    title = Random.nextInt().toString(),
                    body = Random.nextInt().toString(),
                    id = Random.nextInt(),
                    priority = Random.nextInt()
                )
            )
        }

        //confirm db is empty
        var notes = dao.getAllNotes()
        assert(notes.isEmpty())

        //Insert notes
        dao.insertNotes(notes = noteList)

        //confirm all notes inserted previously are retrieved
        notes = dao.getAllNotes()
        assert(notes.isNotEmpty())
        assert(notes.size == noteList.size)
    }

}