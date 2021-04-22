package com.homalab.android.w2.ui.pages.log

import android.os.Bundle
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
import com.homalab.android.w2.R
import com.homalab.android.w2.common.util.AnimUtil
import com.homalab.android.w2.data.entity.Category
import com.homalab.android.w2.data.entity.Expense
import com.homalab.android.w2.databinding.FragmentLogBinding
import com.homalab.android.w2.ui.main.intent.MainIntent
import com.homalab.android.w2.ui.main.viewmodel.MainViewModel
import com.homalab.android.w2.ui.main.viewstate.MainState
import com.homalab.android.w2.ui.pages.log.account.SelectionAccountAdapter
import com.homalab.android.w2.ui.pages.log.category.SelectionCategoryAdapter
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
    private lateinit var binding: FragmentLogBinding

    private lateinit var mBottomSheetSelector: BottomSheetBehavior<View>

    private val selectionCategoryAdapter by lazy {
        SelectionCategoryAdapter(
            object : SelectionCategoryAdapter.CategorySelectionListener {
                override fun onDepthChanged(isRoot: Boolean, isBack: Boolean) {
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

                override fun onDive(categoryName: String) {
                    binding.bottomSheetSelection.textTitle.text = categoryName
                }

                override fun onSelected(category: Category) {
                    //TODO Select!
                }
            })
    }

    private val selectionAccountAdapter by lazy {
        SelectionAccountAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeData() {
        with(mainViewModel) {
            lifecycleScope.launch {
                state.collect {
                    when (it) {
                        is MainState.CategoriesReturned -> selectionCategoryAdapter.setCategories(BottomSheetType.CATEGORY.name, it.categories)
                        is MainState.AccountsReturned -> selectionAccountAdapter.setAccountsList(it.accounts)
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
                test()
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
            bottomSheetSelection.containerTitle.setOnClickListener {
                selectionCategoryAdapter.backToPrevious()
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
                    textTitle.text = type.name
                    recyclerViewSelection.run {
                        adapter = selectionAccountAdapter
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
            BottomSheetType.CATEGORY -> {
                binding.bottomSheetSelection.run {
                    textTitle.text = type.name
                    recyclerViewSelection.run {
                        adapter = selectionCategoryAdapter
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }
        mBottomSheetSelector.state = BottomSheetBehavior.STATE_EXPANDED
    }

    enum class BottomSheetType {
        ACCOUNT, CATEGORY
    }

    companion object {
        @JvmStatic
        fun newInstance() = LogFragment()
    }
}