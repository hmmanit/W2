package com.homalab.android.w2.ui.pages.setting.features.category.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.homalab.android.w2.R
import com.homalab.android.w2.databinding.DialogFragmentCoeCategoryBinding

class CoeCategoryDialog : DialogFragment() {

    private lateinit var binding: DialogFragmentCoeCategoryBinding

    companion object {
        fun show(fragmentActivity: FragmentActivity): CoeCategoryDialog {
            val dialog = CoeCategoryDialog()
            dialog.show(
                fragmentActivity.supportFragmentManager,
                CoeCategoryDialog::class.java.simpleName
            )
            return dialog
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT

            it.window?.apply {
                setLayout(width, height)
                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//                setWindowAnimations(R.style.DialogZoomInOut)
//                    DialogUtil.scaleWidth(this, DialogUtil.COMMON_DIALOG_SCALE)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.dialog_fragment_coe_category,
            container,
            false
        )
        return binding.root
    }
}