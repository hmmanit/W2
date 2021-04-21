package com.homalab.android.w2.ui.pages.log.account

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.homalab.android.w2.R
import com.homalab.android.w2.data.entity.Accounts
import com.homanad.android.common.components.recyclerView.util.DiffCallback
import com.homanad.android.common.extensions.view.visible

class SelectionAccountAdapter : RecyclerView.Adapter<SelectionAccountAdapter.ItemHolder>() {

    private var accountsList = listOf<Accounts>()

    fun setAccountsList(accountsList: List<Accounts>) {
        val diffCallback = DiffCallback(this.accountsList, accountsList)
        this.accountsList = accountsList
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textName = view.findViewById<TextView>(R.id.text_name)
        private val iconSub = view.findViewById<ImageView>(R.id.icon_sub)

        fun bind(accounts: Accounts) {

            textName.text = accounts.accountGroup.name
            if (accounts.accounts.isNotEmpty()) iconSub.visible()
            else iconSub.invalidate()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_selection_category, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return accountsList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(accountsList[position])
    }
}