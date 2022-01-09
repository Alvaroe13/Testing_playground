package com.alvaro.room.testing.data.cache

import com.alvaro.room.testing.data.NoteDataFactory

class NoteDatabaseFake {

    var notes = mutableListOf<NoteEntity>()

    init {
        notes = getData() as MutableList<NoteEntity>
    }

    private fun getData(): List<NoteEntity> {
        var list: List<NoteEntity>? = null
        this.javaClass.classLoader?.let {
           list = NoteDataFactory(testClassLoader = it).getNotesKotlin()
        }
       list ?: throw Exception("NoteDatabaseFake: Data list null")

       return list as List<NoteEntity>
    }
}