package com.homalab.android.w2.ui.pages.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.homalab.android.w2.R
import com.homalab.android.w2.data.model.Spending
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
            lifecycleScope.launch {
                when (answerType) {
                    AnswerType.PAY -> {
                        mainViewModel.userIntent.send(
                            MainIntent.CreateSpendingIntent(
                                Spending(
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

                        mainViewModel.userIntent.send(MainIntent.GetAllSpendingIntent)
                    }
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
                        is MainState.SpendingList -> {
                            activityAdapter.setActivities(it.spendingList.convertToActivities())
                        }
                    }
                }
            }
        }
    }

    override fun setupViewModel() {
        lifecycleScope.launch {
            mainViewModel.userIntent.send(MainIntent.GetAllSpendingIntent)
        }
    }

    override fun updateUI() {
        with(binding) {
            recyclerViewAnswers.run {
                adapter = answerAdapter
                addItemDecoration(SpaceItemDecoration(8))
            }
            recyclerViewActivities.run {
                adapter = activityAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}