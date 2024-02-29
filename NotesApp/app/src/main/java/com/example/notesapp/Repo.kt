package com.example.notesapp

import com.example.notesapp.db.Note
import com.example.notesapp.db.dao

class Repo(private val dao:dao) {

    fun insert(note: Note){
        dao.insert(note)
    }
    fun delete(note: Note){
        dao.delete(note)
    }
    suspend fun update(note: Note){
        dao.update(note)
    }

    fun gellAllNotes()=dao.getAllNotes()
}