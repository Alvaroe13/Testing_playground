package com.alvaro.room.testing.data.dataSet

import com.alvaro.room.testing.data.cache.NoteEntity


/**
 * created this class because java class loader was not loading 'note-list.json'
 */
object NoteListDataSetFake {

    var notes = listOf<NoteEntity>()

    init {
        notes = populateList()
    }

    private fun populateList(): List<NoteEntity> {

        val notes = mutableListOf<NoteEntity>()

        notes.add(
            NoteEntity(
                id = "2474abea-7584-486b-9f88-87a21870b0ec",
                title = "Vancouver PNE 2019",
                body = "Whatever 1.",
                priority = "0"
            )
        )
        notes.add(
            NoteEntity(
                id = "474abea-7584-486b-9f88-87a21870b0ec",
                title = "Minnesota PNE 2019",
                body = "Clean the house.",
                priority = "1"
            )
        )
        notes.add(
            NoteEntity(
                id = "74abea-7584-486b-9f88-87a21870b0ec",
                title = "New York PNE 2019",
                body = "Tke out the trash.",
                priority = "2"
            )
        )
        notes.add(
            NoteEntity(
                id = "4abea-7584-486b-9f88-87a21870b0ec",
                title = "Seattle PNE 2019",
                body = "Shave.",
                priority = "4"
            )
        )
        notes.add(
            NoteEntity(
                id = "bea-7584-486b-9f88-87a21870b0ec",
                title = "London PNE 2019",
                body = "Study to become better.",
                priority = "2"
            )
        )
        notes.add(
            NoteEntity(
                id = "ea-7584-486b-9f88-87a21870b0ec",
                title = "Madrid PNE 2019",
                body = "Learn economics.",
                priority = "1"
            )
        )
        notes.add(
            NoteEntity(
                id = "a-7584-486b-9f88-87a21870b0ec",
                title = "Paris PNE 2019",
                body = "Watch the movie.",
                priority = "5"
            )
        )
        notes.add(
            NoteEntity(
                id = "-7584-486b-9f88-87a21870b0ec",
                title = "Berlin PNE 2019",
                body = "Work out.",
                priority = "3"
            )
        )

        notes.add(
            NoteEntity(
                id = "7584-486b-9f88-87a21870b0ec",
                title = "Amsterdam PNE 2019",
                body = "DO whatever.",
                priority = "1"
            )
        )

        return notes
    }


}