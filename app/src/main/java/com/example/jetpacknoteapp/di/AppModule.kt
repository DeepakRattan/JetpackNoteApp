package com.example.jetpacknoteapp.di

import android.content.Context
import androidx.room.Room
import com.example.jetpacknoteapp.model.NoteDao
import com.example.jetpacknoteapp.model.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Deepak Rattan on 13/04/23
 */

// A Hilt module is a class that is annotated with @Module. Like a Dagger module,
// it informs Hilt how to provide instances of certain types. Unlike Dagger modules,
// you must annotate Hilt modules with @InstallIn to tell Hilt which Android class each module will be used or installed in.

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(
            context = context,
            NoteDatabase::class.java,
            name = "notes_db"
        )
            .fallbackToDestructiveMigration()
            .build()

}