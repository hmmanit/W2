package com.homalab.android.w2.ui.pages.setting.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.homalab.android.w2.R
import com.homalab.android.w2.ui.pages.setting.model.SettingType
import com.homanad.android.common.extensions.resource.asString

class SettingAdapter(
    private val onClick: (view: View, settingType: SettingType) -> Unit
) : RecyclerView.Adapter<SettingAdapter.ItemHolder>() {

    private val settingTypes = listOf(
        SettingType.UI,
        SettingType.CATEGORY,
        SettingType.CONFIGURATION,
        SettingType.SECURITY,
        SettingType.CURRENCY,
        SettingType.BACKUP_RESTORE
    )

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val context = view.context

        private val root = view.rootView
        private val icon = view.findViewById<ImageView>(R.id.icon)
        private val textTitle = view.findViewById<TextView>(R.id.text_title)
//        private val textDescription = view.findViewById<TextView>(R.id.text_description)

        fun bind(settingType: SettingType) {
            icon.setImageResource(settingType.icon)
            textTitle.text = settingType.title.asString(context)
//            textDescription.text = settingType.description.asString(context)

            root.setOnClickListener {
                onClick(it, settingType)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_setting, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return settingTypes.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(settingTypes[position])
    }
}