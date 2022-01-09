package com.alvaro.room.testing.data

import com.alvaro.room.testing.data.cache.NoteEntity
import com.alvaro.room.testing.data.dataSet.NoteListDataSetFake
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * This class takes json and serialize it to kotlin object using Gson lib (not working)
 */
class NoteDataFactory(
    private val testClassLoader: ClassLoader
) {

    fun getNotes() = produceListOfNotes()

    private fun produceListOfNotes(): List<NoteEntity> {
        return Gson()
            .fromJson(
                getNotesFromFile("data-set/$JSON_FILE_NAME"),
                object : TypeToken<List<NoteEntity>>() {}.type
            )
    }

    private fun getNotesFromFile(fileName: String): String {
        return testClassLoader.getResource(fileName).readText()
    }

    companion object {
        const val JSON_FILE_NAME = "note-list.json"
    }



    //using kotlin objects instead, java class loader doesn't read json
    fun getNotesKotlin() = produceList()

    private fun produceList(): List<NoteEntity> {
        return NoteListDataSetFake.notes
    }
}