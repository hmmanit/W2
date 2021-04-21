package com.homalab.android.w2.ui.pages.log.category

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.homalab.android.w2.R
import com.homalab.android.w2.data.entity.Category
import com.homanad.android.common.components.recyclerView.util.DiffCallback
import com.homanad.android.common.extensions.view.invisible
import com.homanad.android.common.extensions.view.visible

class SelectionCategoryAdapter : RecyclerView.Adapter<SelectionCategoryAdapter.ItemHolder>() {

    private var categories = listOf<Category>()

    fun setCategories(categories: List<Category>) {
        val diffCallback = DiffCallback(this.categories, categories)
        this.categories = categories
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textName = view.findViewById<TextView>(R.id.text_name)
        private val iconSub = view.findViewById<ImageView>(R.id.icon_sub)

        fun bind(category: Category) {

            textName.text = category.name
            if (category.subCategories.isNotEmpty()) iconSub.visible()
            else iconSub.invisible()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_selection_category, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(categories[position])
    }
}