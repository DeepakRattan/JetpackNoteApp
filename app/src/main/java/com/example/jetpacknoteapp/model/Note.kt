package com.example.jetpacknoteapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.UUID

/**
 * Created by Deepak Rattan on 10/04/23
 */

data class Note @RequiresApi(Build.VERSION_CODES.O) constructor(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)