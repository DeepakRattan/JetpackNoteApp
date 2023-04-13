package com.example.jetpacknoteapp.repository

import com.example.jetpacknoteapp.model.Note
import com.example.jetpacknoteapp.model.NoteDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Deepak Rattan on 13/04/23
 */
class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    // Add Note
    suspend fun addNote(note: Note) = noteDao.insert(note)

    // Update Note
    suspend fun updateNote(note: Note) = noteDao.update(note)

    // Delete Note
    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

    // Delete All Note
    suspend fun deleteAllNote() = noteDao.deleteAll()

    // Get All Notes
    fun getAllNotes() = noteDao.getNotes().flowOn(Dispatchers.IO).conflate()

}