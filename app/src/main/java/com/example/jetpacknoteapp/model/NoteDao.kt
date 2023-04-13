package com.example.jetpacknoteapp.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by Deepak Rattan on 13/04/23
 */

// Data Access Object
@Dao
interface NoteDao {
    //Get all Notes
    @Query("select * from notes_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query("select * from notes_tbl where id=:id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("delete from notes_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)


}