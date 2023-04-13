package com.example.jetpacknoteapp.util

import androidx.room.TypeConverter
import java.util.Date

/**
 * Created by Deepak Rattan on 13/04/23
 */
class DateConverter {

    @TypeConverter
    fun timeStampFromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun dateFromTimeStamp(timestamp: Long): Date? {
        return Date(timestamp)
    }
}