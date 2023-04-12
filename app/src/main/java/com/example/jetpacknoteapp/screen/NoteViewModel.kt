package com.example.jetpacknoteapp.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.jetpacknoteapp.data.NotesDataSource
import com.example.jetpacknoteapp.model.Note

/**
 * Created by Deepak Rattan on 12/04/23
 */

@RequiresApi(Build.VERSION_CODES.O)
class NoteViewModel : ViewModel() {
    var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note> {
        return noteList
    }
}