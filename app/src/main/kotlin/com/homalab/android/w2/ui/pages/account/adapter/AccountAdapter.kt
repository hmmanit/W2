package com.homalab.android.w2.ui.pages.account.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.homalab.android.w2.R
import com.homalab.android.w2.data.entity.Accounts

class AccountAdapter : RecyclerView.Adapter<AccountAdapter.ItemHolder>() {

    private val accounts = listOf<Accounts>()

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