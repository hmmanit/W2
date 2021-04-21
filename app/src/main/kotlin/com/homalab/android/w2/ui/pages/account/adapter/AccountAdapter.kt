package com.homalab.android.w2.ui.pages.account.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.homalab.android.w2.R
import com.homalab.android.w2.data.entity.Accounts
import com.homanad.android.common.components.recyclerView.util.DiffCallback

class AccountAdapter : RecyclerView.Adapter<AccountAdapter.ItemHolder>() {

    private var accounts = listOf<Accounts>()

    fun setAccounts(accounts: List<Accounts>){
        val diffCallback = DiffCallback(this.accounts, accounts)
        this.accounts = accounts
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textName = view.findViewById<MaterialTextView>(R.id.text_name)

        fun bind(accounts: Accounts) {

            textName.text = accounts.accountGroup?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_account, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return accounts.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(accounts[position])
    }
}