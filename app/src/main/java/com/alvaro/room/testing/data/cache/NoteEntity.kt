package com.alvaro.room.testing.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NotesTable")
data class NoteEntity(

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "body")
    var body: String,

    @ColumnInfo(name = "priority")
    var priority: String,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: String,
)
