package com.homalab.android.w2.ui.pages.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.homalab.android.w2.R
import com.homalab.android.w2.common.util.Constants
import com.homalab.android.w2.data.entity.Expense
import com.homalab.android.w2.databinding.FragmentHomeBinding
import com.homalab.android.w2.mapper.convertToActivities
import com.homalab.android.w2.ui.main.intent.MainIntent
import com.homalab.android.w2.ui.main.viewmodel.MainViewModel
import com.homalab.android.w2.ui.main.viewstate.MainState
import com.homalab.android.w2.ui.pages.home.adapter.ActivityAdapter
import com.homalab.android.w2.ui.pages.home.adapter.AnswerAdapter
import com.homalab.android.w2.ui.pages.home.model.AnswerType
import com.homanad.android.common.components.recyclerView.decoration.SpaceItemDecoration
import com.homanad.android.common.components.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private val mainViewModel: MainViewModel by viewModels()

    private val answerAdapter by lazy {
        AnswerAdapter { view, answerType ->
            when (answerType) {
                AnswerType.EXPENSE -> {
                    navigateTo(HomeFragmentDirections.actionHomeFragmentToLogFragment())
                }
            }
        }
    }

    private val activityAdapter by lazy {
        ActivityAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun observeData() {
        with(mainViewModel) {
            lifecycleScope.launch {
                state.collect {
                    when (it) {
                        is MainState.Expenses -> {
                            activityAdapter.setActivities(it.expenseList.convertToActivities())
                        }
                    }
                }
            }
        }
    }

    override fun setupViewModel() {
        lifecycleScope.launch {
            mainViewModel.userIntent.send(MainIntent.GetAllExpensesIntent)
        }
    }

    override fun updateUI() {
        with(binding) {
            recyclerViewAnswers.run {
                adapter = answerAdapter
                addItemDecoration(SpaceItemDecoration(Constants.SPACE_ITEM_DECORATION))
            }
            recyclerViewActivities.run {
                adapter = activityAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    private fun navigateTo(direction: NavDirections) {
        findNavController().navigate(direction)
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
        fun newInstance() = HomeFragment()
    }
}