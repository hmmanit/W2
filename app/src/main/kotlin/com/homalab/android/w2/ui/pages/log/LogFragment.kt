package com.homalab.android.w2.ui.pages.log

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LayoutAnimationController
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayoutMediator
import com.homalab.android.w2.R
import com.homalab.android.w2.common.util.AnimUtil
import com.homalab.android.w2.data.entity.Account
import com.homalab.android.w2.data.entity.Category
import com.homalab.android.w2.data.entity.Expense
import com.homalab.android.w2.data.entity.Income
import com.homalab.android.w2.databinding.FragmentLogBinding
import com.homalab.android.w2.ui.main.intent.MainIntent
import com.homalab.android.w2.ui.main.viewmodel.MainViewModel
import com.homalab.android.w2.ui.main.viewstate.MainState
import com.homalab.android.w2.ui.pages.log.account.SlidingAccountAdapter
import com.homalab.android.w2.ui.pages.log.category.SelectionCategoryAdapter
import com.homalab.android.w2.ui.pages.log.viewmodel.LogViewModel
import com.homanad.android.common.components.ui.BaseFragment
import com.homanad.android.common.extensions.view.gone
import com.homanad.android.common.extensions.view.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class LogFragment : BaseFragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private val logViewModel: LogViewModel by viewModels()
    private lateinit var binding: FragmentLogBinding

    private lateinit var mBottomSheetSelector: BottomSheetBehavior<View>

    private val selectionCategoryAdapter by lazy {
        SelectionCategoryAdapter(
            object : SelectionCategoryAdapter.CategorySelectionListener {
                override fun onDepthChanged(
                    categoryName: String,
                    isRoot: Boolean,
                    isBack: Boolean
                ) {
                    binding.bottomSheetSelection.textTitle.text = categoryName

                    if (isRoot) binding.bottomSheetSelection.iconPrevious.gone()
                    else binding.bottomSheetSelection.iconPrevious.visible()

                    binding.bottomSheetSelection.recyclerViewSelection.layoutAnimation = if (isBack)
                        LayoutAnimationController(
                            AnimUtil.getSlideInFromLeftAnimation(requireContext())
                        )
                    else LayoutAnimationController(
                        AnimUtil.getSlideInFromRightAnimation(requireContext())
                    )
                }

                override fun onSelected(category: Category) {
                    binding.textCategory.setText(category.name)
                    categoryId = category.id
                    hideBottomSheet()
                }
            })
    }

    private val slidingAccountAdapter by lazy {
        SlidingAccountAdapter(object : SlidingAccountAdapter.SelectionAccountListener {
            override fun onSelected(account: Account) {
                binding.textAccount.setText(account.name)
                accountId = account.id
                hideBottomSheet()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeData() {
        with(mainViewModel) {
            lifecycleScope.launch {
                state.collect {
                    when (it) {
                        is MainState.CategoriesReturned -> selectionCategoryAdapter.setRawCategories(
                            BottomSheetType.CATEGORY.name,
                            it.categories
                        )
                        is MainState.AccountsReturned -> {
                            slidingAccountAdapter.setAccounts(it.accounts)

                            TabLayoutMediator(
                                binding.bottomSheetSelection.tabAccounts,
                                binding.bottomSheetSelection.pageAccounts,
                                TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                                    tab.text = it.accounts[position].accountGroup.name
                                }).attach()
                        }
                    }
                }
            }
        }
    }

    override fun setupViewModel() {
        lifecycleScope.launch {
            mainViewModel.userIntent.send(MainIntent.GetAllCategoriesIntent(Category.Type.EXPENSE)) //TODO test expense
            mainViewModel.userIntent.send(MainIntent.GetAllAccountsIntent)
        }

    }

    override fun updateUI() {
        initBottomSheetSelector()
        with(binding) {
            buttonSave.setOnClickListener {
//                test()
                collect()
                findNavController().navigateUp()
            }
            header.buttonBack.setOnClickListener {
                findNavController().navigateUp()
            }
            textAccount.setOnClickListener {
                showBottomSheetInMode(BottomSheetType.ACCOUNT)
            }
            textCategory.setOnClickListener {
                showBottomSheetInMode(BottomSheetType.CATEGORY)
            }
            bottomSheetSelection.run {
                containerTitle.setOnClickListener {
                    selectionCategoryAdapter.backToPrevious()
                }

                recyclerViewSelection.run {
                    adapter = selectionCategoryAdapter
                    layoutManager = LinearLayoutManager(requireContext())
                }

                pageAccounts.run {
                    adapter = slidingAccountAdapter
                }
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

    private var accountId: Long = 0
    private var categoryId: Long = 0

    private fun collect() {
        val amount = binding.textAmount.text.toString()
        val note = binding.textNote.text.toString()
        val description = binding.textDescription.text.toString()

        when (binding.toggleGroup.checkedButtonId) {
            R.id.button_expense -> {
                Log.d("aaaaaaaaaaaaaaaaaaaaaaaa", "expense")
                lifecycleScope.launch {
                    mainViewModel.userIntent.send(
                        MainIntent.CreateExpenseIntent(
                            Expense(
                                0,
                                note,
                                description,
                                amount.toFloat(),
                                accountId,
                                categoryId,
                                System.currentTimeMillis(),
                                System.currentTimeMillis()
                            )
                        )
                    )

                    mainViewModel.userIntent.send(MainIntent.GetAllExpensesIntent)
                }
            }
            R.id.button_income -> {
                Log.d("aaaaaaaaaaaaaaaaaaaaaaaa", "income")
                lifecycleScope.launch {
                    mainViewModel.userIntent.send(
                        MainIntent.CreateIncomeIntent(
                            Income(
                                0,
                                note,
                                description,
                                amount.toFloat(),
                                accountId,
                                categoryId,
                                System.currentTimeMillis(),
                                System.currentTimeMillis()
                            )
                        )
                    )

                    mainViewModel.userIntent.send(MainIntent.GetAllExpensesIntent)
                }
            }
        }


    }

    private fun initBottomSheetSelector() {
        val bottomSheetContentView = requireView().findViewById<View>(R.id.bottom_sheet_selection)
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

    private fun showBottomSheetInMode(type: BottomSheetType) {
        when (type) {
            BottomSheetType.ACCOUNT -> {
                binding.bottomSheetSelection.run {
                    containerAccountSelection.visible()
                    recyclerViewSelection.gone()
                }
            }
            BottomSheetType.CATEGORY -> {
                binding.bottomSheetSelection.run {
                    recyclerViewSelection.visible()
                    containerAccountSelection.gone()
                }
            }
        }
        mBottomSheetSelector.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun hideBottomSheet() {
        mBottomSheetSelector.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    enum class BottomSheetType {
        ACCOUNT, CATEGORY
    }

    companion object {
        @JvmStatic
        fun newInstance() = LogFragment()
    }
}