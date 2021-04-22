package com.homalab.android.w2.ui.pages.log.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.homalab.android.w2.R
import com.homalab.android.w2.common.util.AnimUtil
import com.homalab.android.w2.data.entity.Category
import com.homanad.android.common.components.recyclerView.util.DiffCallback
import com.homanad.android.common.extensions.view.invisible
import com.homanad.android.common.extensions.view.visible

class SelectionCategoryAdapter(
    private val context: Context,
    private val categorySelectionListener: CategorySelectionListener
) :
    RecyclerView.Adapter<SelectionCategoryAdapter.ItemHolder>() {

    companion object {
        private const val ROOT_DEEP = 1
    }

    private var categories = listOf<Category>()
    private val histories = mutableMapOf<Int, List<Category>>()

    private var appearanceAnimation = AnimUtil.getSlideInFromRightAnimation(context)

    private var depth = ROOT_DEEP

    fun setCategories(categories: List<Category>) {
        val diffCallback = DiffCallback(this.categories, categories)

        this.categories = categories

        val newDepth = if (categories.isNotEmpty()) categories[0].depth else ROOT_DEEP
        appearanceAnimation =
            if (depth < newDepth) AnimUtil.getSlideInFromRightAnimation(context)
            else AnimUtil.getSlideInFromLeftAnimation(context)

        depth = newDepth

        histories[depth] = categories

        categorySelectionListener.onDeepChanged(depth == ROOT_DEEP)

        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    fun backToPrevious() { //TODO temp solution
        setCategories(histories[depth-1] ?: listOf())
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val root = view.rootView
        private val textName = view.findViewById<TextView>(R.id.text_name)
        private val iconSub = view.findViewById<ImageView>(R.id.icon_sub)

        fun bind(category: Category) {
            root.startAnimation(appearanceAnimation)

            textName.text = category.name
            if (category.subCategories.isNotEmpty()) {
                iconSub.visible()

                root.setOnClickListener {
                    setCategories(category.subCategories)
                }
            } else iconSub.invisible()
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
        fun onDeepChanged(isRoot: Boolean)
    }
}