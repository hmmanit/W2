package com.homalab.android.w2.ui.pages.log.account

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.homalab.android.w2.R
import com.homalab.android.w2.data.entity.Account
import com.homalab.android.w2.data.entity.Accounts
import com.homanad.android.common.components.recyclerView.util.DiffCallback

class SlidingAccountAdapter(
    private val selectionAccountListener: SelectionAccountListener
) : RecyclerView.Adapter<SlidingAccountAdapter.ItemHolder>() {

    private var accounts = listOf<Accounts>()

    fun setAccounts(accounts: List<Accounts>) {
        val diffCallback = DiffCallback(this.accounts, accounts)
        this.accounts = accounts
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val recyclerViewAccounts =
            view.findViewById<RecyclerView>(R.id.recycler_view_accounts)

        fun bind(accounts: Accounts) {
            val selectionAccountAdapter = SelectionAccountAdapter(selectionAccountListener)
            selectionAccountAdapter.setAccounts(accounts.accounts)
            recyclerViewAccounts.run {
                adapter = selectionAccountAdapter
                layoutManager = GridLayoutManager(context, 3)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sliding_account, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return accounts.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(accounts[position])
    }

    interface SelectionAccountListener {
        fun onSelected(account: Account)
    }
}