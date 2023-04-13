package com.example.jetpacknoteapp.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Deepak Rattan on 13/04/23
 */

fun formatDate(time:Long):String{
    val date = Date(time)
    val sdf = SimpleDateFormat("EEE, d MMM hh:mm aaa",Locale.getDefault())
    return sdf.format(date)

}