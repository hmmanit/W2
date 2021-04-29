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
import com.homalab.android.w2.ui.pages.log.LogFragment
import com.homanad.android.common.components.recyclerView.util.DiffCallback
import com.homanad.android.common.extensions.view.invisible
import com.homanad.android.common.extensions.view.visible
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SelectionCategoryAdapter(
    private val categorySelectionListener: CategorySelectionListener
) : RecyclerView.Adapter<SelectionCategoryAdapter.ItemHolder>() {

    companion object {
        private const val ROOT_PARENT_ID: Long = -1
    }

    private var rawCategories = listOf<Category>()
    private var categories = listOf<Category>()

    private var parentId = ROOT_PARENT_ID

    fun set(categoryTitle: String, categories: List<Category>) {
        rawCategories = categories
        setCategories(categoryTitle, rawCategories.dive(parentId), false)
    }

    private fun setCategories(categoryTitle: String, categories: List<Category>, isBack: Boolean) {
        val diffCallback = DiffCallback(this.categories, categories)

        this.categories = categories

        val newParentId = if (categories.isNotEmpty()) categories[0].parentId else ROOT_PARENT_ID

        categorySelectionListener.onDepthChanged(newParentId == ROOT_PARENT_ID, isBack)

        parentId = newParentId
        categorySelectionListener.onDive(categoryTitle)

        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    fun backToPrevious() { //TODO temp solution
        if (parentId == ROOT_PARENT_ID) return
        val currentParentId = if (categories.isNotEmpty()) categories[0].parentId else -1
        val category = rawCategories.findById(currentParentId)
        val categoryName =
            if (category.parentId == -1L) LogFragment.BottomSheetType.CATEGORY.name else category.name
        setCategories(categoryName, rawCategories.dive(category.parentId), true)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val root = view.rootView
        private val textName = view.findViewById<TextView>(R.id.text_name)
        private val iconSub = view.findViewById<ImageView>(R.id.icon_sub)

        fun bind(category: Category) {

            textName.text = category.name
            val subCategories = rawCategories.dive(category.id)
            if (subCategories.isNotEmpty()) {
                iconSub.visible()

                root.setOnClickListener {
                    setCategories(category.name, subCategories, false)
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

    fun List<Category>.dive(id: Long): List<Category> {
        return filter {
            it.parentId == id
        }
    }

    private fun List<Category>.findById(id: Long): Category {
        return filter {
            it.id == id
        }[0]
    }
}