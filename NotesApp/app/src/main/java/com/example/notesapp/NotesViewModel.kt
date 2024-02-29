package com.example.notesapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.db.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(
    private val repo: Repo
) : ViewModel() {

    fun insert(note: Note) {
        //this code is used(anywhere) change the thread
        // ,in this case we going to main thread to background thread becouse - viewModelScope.launch(Dispatchers.IO) {}
        // ,we want that this code exicute at bacground thread like fetching data
        // ,such that no crashes or error comes to mean thread/ui thread
        viewModelScope.launch(Dispatchers.IO) {
            repo.insert(note)
        }

    }

    fun delete(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.delete(note)
        }
    }

    fun update(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.update(note)
        }
    }

    fun getAllNotes() = repo.gellAllNotes()
}