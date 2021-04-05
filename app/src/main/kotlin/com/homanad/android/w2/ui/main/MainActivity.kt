package com.homanad.android.w2.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewbinding.ViewBinding
import com.homanad.android.common.components.ui.BaseActivityWithBinding
import com.homanad.android.common.components.ui.binding.contentView
import com.homanad.android.w2.R
import com.homanad.android.w2.databinding.ActivityMainBinding
import com.homanad.android.w2.ui.main.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem

@ExperimentalCoroutinesApi
class MainActivity : BaseActivityWithBinding() {

    private val mainViewModel: MainViewModel by viewModels()


    override val binding: ActivityMainBinding by contentView(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun observeData() {

    }

    override fun updateUI() {
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.accountFragment,
                R.id.statisticFragment,
                R.id.settingFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

//        val menuItems = arrayOf(
//            CbnMenuItem(
//                R.drawable.ic_notification,
//                R.drawable.avd_notification,
//                R.id.navigation_notifications
//            ),
//            CbnMenuItem(
//                R.drawable.ic_dashboard,
//                R.drawable.avd_dashboard,
//                R.id.navigation_dashboard
//            ),
//            CbnMenuItem(R.drawable.ic_home, R.drawable.avd_home, R.id.navigation_home),
//            CbnMenuItem(
//                R.drawable.ic_profile,
//                R.drawable.avd_profile,
//                R.id.navigation_profile
//            ),
//            CbnMenuItem(
//                R.drawable.ic_settings,
//                R.drawable.avd_settings,
//                R.id.navigation_settings
//            )
//        )
//        binding.navView.setMenuItems(menuItems, 0)
//        binding.navView.setupWithNavController(navController)
    }
}