package com.homalab.android.w2.ui.pages.log.category

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

class SelectionCategoryAdapter(
    private val categorySelectionListener: CategorySelectionListener
) : RecyclerView.Adapter<SelectionCategoryAdapter.ItemHolder>() {

    companion object {
        private const val ROOT_DEPTH = 1
    }

    private var categories = listOf<Category>()
    private val histories = mutableMapOf<Int, Pair<String, List<Category>>>()

    private var depth = ROOT_DEPTH

    fun setCategories(categoryTitle: String, categories: List<Category>) {
        val diffCallback = DiffCallback(this.categories, categories)

        this.categories = categories

        val newDepth = if (categories.isNotEmpty()) categories[0].depth else ROOT_DEPTH

        categorySelectionListener.onDepthChanged(newDepth == ROOT_DEPTH, newDepth < depth)

        depth = newDepth
        histories[depth] = categoryTitle to categories
        categorySelectionListener.onDive(categoryTitle)

        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    fun backToPrevious() { //TODO temp solution
        if (depth == ROOT_DEPTH) return
        val history = histories[depth - 1]
        setCategories(history?.first ?: "", history?.second ?: listOf())
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val root = view.rootView
        private val textName = view.findViewById<TextView>(R.id.text_name)
        private val iconSub = view.findViewById<ImageView>(R.id.icon_sub)

        fun bind(category: Category) {

            textName.text = category.name
            val subCategories = dive(category.id)
            if (subCategories.isNotEmpty()) {
                iconSub.visible()

                root.setOnClickListener {
                    setCategories(category.name, subCategories)
                }
            } else {
                iconSub.invisible()

                root.setOnClickListener {
                    categorySelectionListener.onSelected(category)
                }
            }
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

    interface CategorySelectionListener {
        fun onDepthChanged(isRoot: Boolean, isBack: Boolean)
        fun onDive(categoryName: String)
        fun onSelected(category: Category)
    }

    private fun dive(id: Long): List<Category>{
       return categories.filter {
            it.parentId == id
        }
    }
}