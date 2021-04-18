package com.homalab.android.w2.common.util

import java.text.SimpleDateFormat
import java.util.*

fun Long.toString(formatPattern: String = "yyyy-MM-dd HH:mm:ss.SSS"): String {
    val formatter = SimpleDateFormat(formatPattern, Locale.getDefault())
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return formatter.format(calendar.time)
}