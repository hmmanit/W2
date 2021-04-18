package com.homalab.android.w2.ui.pages.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.homalab.android.w2.R
import com.homalab.android.w2.ui.pages.home.type.AnswerType
import com.homanad.android.common.extensions.resource.asString

class AnswerAdapter : RecyclerView.Adapter<AnswerAdapter.ItemHolder>() {

    private val answerTypes = listOf(
        AnswerType.PAY,
        AnswerType.TEST1,
        AnswerType.TEST2,
        AnswerType.TEST3,
        AnswerType.TEST4
    )

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val context = view.context
        private val icon = view.findViewById<ImageView>(R.id.icon)
        private val textTitle = view.findViewById<TextView>(R.id.text_title)
        private val textDescription = view.findViewById<TextView>(R.id.text_description)

        fun bind(answerType: AnswerType) {
            icon.setImageResource(answerType.icon)
            textTitle.text = answerType.title.asString(context)
            textDescription.text = answerType.description.asString(context)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_answer, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return answerTypes.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(answerTypes[position])
    }
}