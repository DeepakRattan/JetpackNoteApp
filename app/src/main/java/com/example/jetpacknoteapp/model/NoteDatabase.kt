package com.example.jetpacknoteapp.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.jetpacknoteapp.util.DateConverter
import com.example.jetpacknoteapp.util.UUIDConverter

/**
 * Created by Deepak Rattan on 13/04/23
 */
@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}