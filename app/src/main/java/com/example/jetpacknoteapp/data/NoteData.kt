package com.example.jetpacknoteapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.jetpacknoteapp.model.Note

/**
 * Created by Deepak Rattan on 10/04/23
 */

class NotesDataSource() {
    @RequiresApi(Build.VERSION_CODES.O)
    // Dummy Data
    fun loadNotes(): List<Note> {
        return listOf(
            Note(
                title = "Coding",
                description = "Practice daily to learn the fundamentals of Coding"
            ),
            Note(
                title = "Teaching",
                description = "Teaching is a profession that teaches other profession"
            ),
            Note(title = "Cricket", description = "IPL matches are started"),
            Note(
                title = "Coding",
                description = "Practice daily to learn the fundamentals of Coding"
            ),
            Note(
                title = "Coding",
                description = "Practice daily to learn the fundamentals of Coding"
            )
        )
    }
}