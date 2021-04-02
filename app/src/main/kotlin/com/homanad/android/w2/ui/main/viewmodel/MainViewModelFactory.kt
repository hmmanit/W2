package com.homanad.android.w2.ui.main.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.homanad.android.w2.di.Injector

class MainViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(
                Injector.provideWalletRepository(context),
                Injector.provideMinusRepository(context)
            ) as T
        throw IllegalArgumentException("Unknown class name")
    }
}