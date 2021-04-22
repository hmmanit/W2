package com.homalab.android.w2.ui.pages.log.account

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.homalab.android.w2.R
import com.homalab.android.w2.data.entity.Account
import com.homanad.android.common.components.recyclerView.util.DiffCallback

class SelectionAccountAdapter(
    private val selectionAccountListener: SlidingAccountAdapter.SelectionAccountListener
) : RecyclerView.Adapter<SelectionAccountAdapter.ItemHolder>() {

    private var accountsList = listOf<Account>()

    fun setAccounts(accountsList: List<Account>) {
        val diffCallback = DiffCallback(this.accountsList, accountsList)
        this.accountsList = accountsList
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val root = view.rootView
        private val textName = view.findViewById<TextView>(R.id.text_name)
        private val textAmount = view.findViewById<TextView>(R.id.text_amount)

        fun bind(account: Account) {

            textName.text = account.name
            textAmount.text = account.budget.toString() //TODO currency formatter

            root.setOnClickListener {
                selectionAccountListener.onSelected(account)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_selection_account, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return accountsList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(accountsList[position])
    }
}