package com.homanad.android.w2.ui.main

import android.app.Activity
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.palette.graphics.Palette
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

        val builder = Palette.Builder(BitmapFactory.decodeResource(resources, R.drawable.day1))
        builder.generate {
            it?.let {
                val light = it.getLightMutedColor(themeColor(R.attr.colorPrimary))
                val dark = it.getDarkVibrantColor(themeColor(R.attr.colorPrimaryDark))

                val gradientDrawable = GradientDrawable()
                val colors = intArrayOf(light, dark)
                gradientDrawable.colors = colors
                gradientDrawable.orientation = GradientDrawable.Orientation.LEFT_RIGHT
                gradientDrawable.gradientType = GradientDrawable.LINEAR_GRADIENT

                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
                window.navigationBarColor = Color.TRANSPARENT
                window.setBackgroundDrawable(gradientDrawable)
            }
        }
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