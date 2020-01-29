package com.example.androidwithkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.androidwithkotlin.entities.Note
import com.example.androidwithkotlin.repository.NoteRepository

class NoteViewModel(application: Application):AndroidViewModel(application) {
    private var repository = NoteRepository(application)
    private var allNotes = repository.getAllNotes()

    fun insert(note: Note) {
        repository.insert(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }
}