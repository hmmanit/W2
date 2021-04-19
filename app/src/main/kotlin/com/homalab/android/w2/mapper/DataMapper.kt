package com.homalab.android.w2.mapper

import com.homalab.android.w2.common.util.toDateString
import com.homalab.android.w2.data.model.Spending
import com.homalab.android.w2.ui.pages.home.model.Activity

fun List<Spending>.convertToActivities(): List<Activity> {
    val pattern = "yyyy-MM-dd"

    val activities = getEmptyActivities(pattern)

    forEach {
        activities.forEach { activity ->
            if (activity.date == it.createdTime.toDateString(pattern)) {
                activity.spending.add(it)
            }
        }
    }

    return activities.toList()
}

//fun List<Spending>.convertToSetOfDate(pattern: String): List<String> {
//    val dates = mutableListOf<String>()
//
//    forEach {
//        dates.add(it.createdTime.toDateString(pattern))
//    }
//
//    return dates.toList()
//}

fun List<Spending>.getEmptyActivities(pattern: String): List<Activity> {
    val activities = mutableListOf<Activity>()
    val dates = mutableSetOf<String>()

    forEach {
        val d = it.createdTime.toDateString(pattern)
        if (dates.add(d)) activities.add(Activity(d))
    }

    return activities.toList()
}
