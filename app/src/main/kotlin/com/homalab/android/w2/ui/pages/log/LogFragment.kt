package com.homalab.android.w2.ui.pages.log

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.homalab.android.w2.R
import com.homalab.android.w2.data.entity.Expense
import com.homalab.android.w2.databinding.FragmentLogBinding
import com.homalab.android.w2.ui.main.intent.MainIntent
import com.homalab.android.w2.ui.main.viewmodel.MainViewModel
import com.homanad.android.common.components.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class LogFragment : BaseFragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentLogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeData() {

    }

    override fun setupViewModel() {

    }

    override fun updateUI() {
        with(binding) {
            buttonSave.setOnClickListener {
                test()
                findNavController().navigateUp()
            }
            header.buttonBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_log, container, false)
        return binding.root
    }

    //TODO testing
    private fun test() {
        lifecycleScope.launch {
            mainViewModel.userIntent.send(
                MainIntent.CreateExpenseIntent(
                    Expense(
                        0,
                        "b",
                        "b",
                        1111f,
                        1,
                        System.currentTimeMillis(),
                        System.currentTimeMillis()
                    )
                )
            )

            mainViewModel.userIntent.send(MainIntent.GetAllExpensesIntent)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LogFragment()
    }
}