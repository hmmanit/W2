package com.homalab.android.w2.ui.pages.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.homalab.android.w2.R
import com.homalab.android.w2.common.util.Constants
import com.homalab.android.w2.databinding.FragmentAccountBinding
import com.homalab.android.w2.ui.main.viewmodel.MainViewModel
import com.homalab.android.w2.ui.pages.account.adapter.AccountAdapter
import com.homanad.android.common.components.recyclerView.decoration.SpaceItemDecoration
import com.homanad.android.common.components.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class AccountFragment : BaseFragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentAccountBinding

    private val accountAdapter by lazy {
        AccountAdapter()
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
            recyclerViewAccounts.run {
                adapter = accountAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(SpaceItemDecoration(Constants.SPACE_ITEM_DECORATION))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)
        return binding.root
    }

    companion object {
        private val TAG = AccountFragment::class.java.simpleName

        @JvmStatic
        fun newInstance() = AccountFragment()
    }
}