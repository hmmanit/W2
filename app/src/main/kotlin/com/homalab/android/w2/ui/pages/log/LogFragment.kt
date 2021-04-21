package com.homalab.android.w2.ui.pages.log

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior
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

    private lateinit var mBottomSheetSelector: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeData() {

    }

    override fun setupViewModel() {

    }

    override fun updateUI() {
        initBottomSheetSelector()
        with(binding) {
            buttonSave.setOnClickListener {
                test()
                findNavController().navigateUp()
            }
            header.buttonBack.setOnClickListener {
                findNavController().navigateUp()
            }
            textAccount.setOnClickListener {
                mBottomSheetSelector.state = BottomSheetBehavior.STATE_EXPANDED
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

    private fun initBottomSheetSelector() {
        val bottomSheetContentView = requireView().findViewById<View>(R.id.bottom_sheet_selector)
        mBottomSheetSelector = BottomSheetBehavior.from(bottomSheetContentView).apply {
            addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(p0: View, p1: Float) {
                    when {
                        p1 > 0.1F -> {
//                            binding.bottomSheetPlayer.collapsedMode.gone()
                        }
                        else -> {
//                            binding.bottomSheetPlayer.collapsedMode.visible()
                        }
                    }
                }

                override fun onStateChanged(p0: View, p1: Int) {
                    when (p1) {
                        BottomSheetBehavior.STATE_HIDDEN -> {
                        }

                        BottomSheetBehavior.STATE_EXPANDED -> {
//                            binding.bottomSheetPlayer.collapsedMode.gone()
                        }

                        BottomSheetBehavior.STATE_COLLAPSED -> {
//                            binding.bottomSheetPlayer.collapsedMode.visible()
                        }

                        BottomSheetBehavior.STATE_DRAGGING -> {
                        }

                        BottomSheetBehavior.STATE_SETTLING -> {
                        }

                        BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        }
                    }
                }
            })
        }

//        binding.bottomSheetPlayer.apply {
//            collapsedMode.setOnClickListener {
//                bottomSheet.state = BottomSheetBehavior.STATE_EXPANDED
//                it.gone()
//                transitionPlayerToStart(true)
//            }
//            btnCollapse.setOnClickListener {
//                bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
//                it.visible()
//            }
//        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LogFragment()
    }
}