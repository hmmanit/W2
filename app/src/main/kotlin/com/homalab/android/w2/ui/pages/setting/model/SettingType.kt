package com.homalab.android.w2.ui.pages.setting.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.homalab.android.w2.R

enum class SettingType(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
) {
    UI(R.drawable.ic_settings, R.string.ui, R.string.app_name),
    CATEGORY(R.drawable.ic_settings, R.string.category, R.string.app_name),
    CONFIGURATION(R.drawable.ic_settings, R.string.configuration, R.string.app_name),
    SECURITY(R.drawable.ic_settings, R.string.security, R.string.app_name),
    CURRENCY(R.drawable.ic_settings, R.string.currency, R.string.app_name),
    BACKUP_RESTORE(R.drawable.ic_settings, R.string.backup_restore, R.string.app_name),
}