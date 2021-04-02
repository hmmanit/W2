package com.homanad.android.w2.ui.main

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.homanad.android.w2.R
import com.homanad.android.w2.ui.main.intent.MainIntent
import com.homanad.android.w2.ui.main.viewmodel.MainViewModel
import com.homanad.android.w2.ui.main.viewmodel.MainViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            lifecycleScope.launch {
                mainViewModel.userIntent.send(MainIntent.GetAllWalletIntent)
            }
        }
    }
}