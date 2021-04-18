package com.homalab.android.w2.ui.pages.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.homalab.android.w2.R
import com.homalab.android.w2.ui.pages.home.model.Activity
import com.homanad.android.common.components.recyclerView.util.DiffCallback

class ActivityAdapter : RecyclerView.Adapter<ActivityAdapter.ItemHolder>() {

    private var activities = listOf<Activity>()

    fun setActivities(activities: List<Activity>) {
        val diffCallback = DiffCallback(this.activities, activities)
        this.activities = activities
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val root = view.rootView
        private val context = view.context
        private val textDate = view.findViewById<TextView>(R.id.text_date)
        private val containerActivity =
            view.findViewById<LinearLayoutCompat>(R.id.container_activity)

        fun bind(activity: Activity) {

            textDate.text = activity.date

            activity.spending.forEach {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.row_activity, containerActivity, false)

                val textTitle = view.findViewById<TextView>(R.id.text_title)
                val textAmount = view.findViewById<TextView>(R.id.text_amount)

                textTitle.text = it.title
                textAmount.text = it.amount.toString()

                containerActivity.addView(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return activities.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(activities[position])
    }
}