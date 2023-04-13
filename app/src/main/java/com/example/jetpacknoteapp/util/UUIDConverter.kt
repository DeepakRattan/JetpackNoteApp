package com.example.jetpacknoteapp.util

import androidx.room.TypeConverter
import java.util.UUID

/**
 * Created by Deepak Rattan on 13/04/23
 */
class UUIDConverter {

    @TypeConverter
    fun uuidToString(uuid: UUID): String? {
        return uuid.toString()
    }

    @TypeConverter
    fun stringToUUID(string: String?): UUID? {
        return UUID.fromString(string)
    }


}