package com.example.jetpacknoteapp.model

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Deepak Rattan on 13/04/23
 */
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

}