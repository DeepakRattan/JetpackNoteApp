package com.example.jetpacknoteapp.di

import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Singleton

/**
 * Created by Deepak Rattan on 13/04/23
 */

// A Hilt module is a class that is annotated with @Module. Like a Dagger module,
// it informs Hilt how to provide instances of certain types. Unlike Dagger modules,
// you must annotate Hilt modules with @InstallIn to tell Hilt which Android class each module will be used or installed in.

@InstallIn(Singleton::class)
@Module
object AppModule {

}