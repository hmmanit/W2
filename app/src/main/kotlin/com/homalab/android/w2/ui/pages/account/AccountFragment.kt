package com.homalab.android.w2.ui.pages.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.homalab.android.w2.R
import com.homalab.android.w2.databinding.FragmentAccountBinding
import com.homanad.android.common.components.ui.BaseFragment

class AccountFragment : BaseFragment() {

    private lateinit var binding: FragmentAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeData() {

    }

    override fun setupViewModel() {

    }

    override fun updateUI() {

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