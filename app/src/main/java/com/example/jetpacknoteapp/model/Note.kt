package com.example.jetpacknoteapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

/**
 * Created by Deepak Rattan on 10/04/23
 */

// Table Name is notes_tbl with columns as id, note_title, note_description and note_entry_date
@Entity(tableName = "notes_tbl")
data class Note @RequiresApi(Build.VERSION_CODES.O) constructor(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_description")
    val description: String,

    @ColumnInfo(name = "note_entry_date")
    val entryDate: Date = Date.from(Instant.now())
)