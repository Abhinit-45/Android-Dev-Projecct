package com.example.notesapp.db

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false

)
abstract class NoteDatabase :RoomDatabase(){

    abstract fun getNoteDao():dao

    companion object{
        private const val DB_NAME="note_database.db"

        private var instance: NoteDatabase?=null

        operator fun invoke(context: Context)= instance ?: synchronized(Any()){
            instance ?: buildDatabase(context).also {
                instance =it
            }
        }

        private fun buildDatabase(context: Context)=Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            DB_NAME
        ).build()
    }

}