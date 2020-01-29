package com.example.androidwithkotlin.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidwithkotlin.dao.NoteDao
import com.example.androidwithkotlin.database.ProjectDB
import com.example.androidwithkotlin.entities.Note

class NoteRepository(application: Application) {
    private var noteDao: NoteDao
   // private val allNotesr: MutableLiveData<List<Note>>
    private val allNotes:LiveData<List<Note>>
    init {
        val db = ProjectDB.getInstance(application)!!
        noteDao = db.noteDao()
        allNotes = noteDao.getAllNotes()
        //allNotes.value = noteDao.getAllNotes()
       // allNotesr = noteDao.getAllNotes()
    }

    fun insert(note:Note){
        noteDao.insert(note)
       // allNotes.value = noteDao.getAllNotes()
    }
    fun deleteAllNotes(){
        noteDao.deleteAllNotes()
    }
    fun getAllNotes():LiveData<List<Note>>{
        return allNotes
    }
}