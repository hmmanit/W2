package com.homanad.android.w2.ui.main

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.homanad.android.common.extensions.context.themeColor
import com.homanad.android.w2.R
import com.homanad.android.w2.databinding.ActivityMainBinding
import com.homanad.android.w2.ui.main.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem


@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setStatusBarGradient(this)

        observeData()
        updateUI()
    }

    private fun setStatusBarGradient(activity: Activity) {
        val window: Window = activity.window

        val gradientDrawable = GradientDrawable()
        val colors = intArrayOf(Color.BLACK, themeColor(R.attr.colorPrimaryDark))
        gradientDrawable.colors = colors
//        gradientDrawable.shape = GradientDrawable.RECTANGLE
        gradientDrawable.orientation = GradientDrawable.Orientation.LEFT_RIGHT
//        gradientDrawable.setStroke(strokeWidth, strokeColor)
        gradientDrawable.gradientType = GradientDrawable.LINEAR_GRADIENT

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT
        window.setBackgroundDrawable(gradientDrawable)
    }

    private fun observeData() {

    }

    private fun updateUI() {
        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navController = findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.homeFragment,
//                R.id.accountFragment,
//                R.id.statisticFragment,
//                R.id.settingFragment
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        val menuItems = arrayOf(
            CbnMenuItem(
                R.drawable.ic_home,
                R.drawable.avd_home,
                R.id.homeFragment
            ),
            CbnMenuItem(
                R.drawable.ic_account,
                R.drawable.avd_account,
                R.id.accountFragment
            ),
            CbnMenuItem(
                R.drawable.ic_statistics,
                R.drawable.avd_statistics,
                R.id.statisticFragment
            ),
            CbnMenuItem(
                R.drawable.ic_settings,
                R.drawable.avd_settings,
                R.id.settingFragment
            )
        )
        binding.navView.setMenuItems(menuItems, 0)
        binding.navView.setupWithNavController(navController)
    }
}