package com.example.jetpacknoteapp.model

import androidx.room.*

/**
 * Created by Deepak Rattan on 13/04/23
 */

// Data Access Object
@Dao
interface NoteDao {
    //Get all Notes
    @Query("select * from notes_tbl")
    fun getNotes(): List<Note>

    @Query("select * from notes_tbl where id=:id")
    fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Note)

    @Query("delete from notes_tbl")
    fun deleteAll()

    @Delete
    fun deleteNote(note: Note)




}