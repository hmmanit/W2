package com.homalab.android.w2.mapper

import com.homalab.android.w2.common.util.toString
import com.homalab.android.w2.data.model.Spending
import com.homalab.android.w2.ui.pages.home.model.Activity

fun List<Spending>.convertToActivities(): List<Activity> {
    val activities = mutableSetOf<Activity>()

    val pattern = "yyyy-MM-dd"

    this.forEach { spending ->
        val activity = Activity(spending.createdTime.toString(pattern))
        activities.add(activity)

        activities.forEach { a ->
            if (a.date == activity.date) {
                a.spending.add(spending)
            }
        }
    }

    return activities.toList()
}