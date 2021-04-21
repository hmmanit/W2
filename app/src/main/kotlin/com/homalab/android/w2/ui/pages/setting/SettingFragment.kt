package com.homalab.android.w2.ui.pages.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.homalab.android.w2.R
import com.homalab.android.w2.common.util.Constants
import com.homalab.android.w2.databinding.FragmentSettingBinding
import com.homalab.android.w2.ui.main.viewmodel.MainViewModel
import com.homalab.android.w2.ui.pages.setting.adapter.SettingAdapter
import com.homalab.android.w2.ui.pages.setting.model.SettingType
import com.homanad.android.common.components.recyclerView.decoration.SpaceItemDecoration
import com.homanad.android.common.components.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class SettingFragment : BaseFragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentSettingBinding

    private val settingAdapter by lazy {
        SettingAdapter { view, settingType ->
            when (settingType) {
                SettingType.CATEGORY -> {
                    navigateTo(SettingFragmentDirections.actionSettingFragmentToCategoryFragment())
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeData() {

    }

    override fun setupViewModel() {
    }


    override fun updateUI() {
        with(binding) {
            recyclerViewSettings.run {
                adapter = settingAdapter
                layoutManager = GridLayoutManager(requireContext(), Constants.SETTING_COLUMN_COUNT)
                addItemDecoration(SpaceItemDecoration(Constants.SPACE_ITEM_DECORATION))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        return binding.root
    }

    private fun navigateTo(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingFragment()
    }
}