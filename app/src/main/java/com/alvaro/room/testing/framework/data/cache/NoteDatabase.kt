package com.alvaro.room.testing.framework.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao() : NoteDao

    companion object {
        const val DB_NAME = "NotesDatabase"
    }

    private fun buildDatabase(context: Context) = Room.databaseBuilder(
        context.applicationContext,
        NoteDatabase::class.java,
        DB_NAME
    ).fallbackToDestructiveMigration().build()

}