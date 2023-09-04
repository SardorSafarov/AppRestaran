package com.example.apprestaran.activity.adminPanel

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.apprestaran.R
import com.example.apprestaran.activity.adminPanel.ui.DrawerOnOffInteface
import com.example.apprestaran.databinding.ActivityAdminMainBinding
import com.example.apprestaran.need.d
import com.example.apprestaran.need.tosat
import com.google.android.material.navigation.NavigationView


class AdminMainActivity : AppCompatActivity(), DrawerOnOffInteface {

    private lateinit var binding: ActivityAdminMainBinding
    private lateinit var navController: NavController
    var doubleBackToExitPressedOnce = false
    lateinit var drawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment_activity_admin_main)
        setupWithNavController(binding.navView, navController)
        navigationFragment()
        navigationDrawerItemClick()
        drawer = binding.drawerLayout
    }

    private fun navigationDrawerItemClick() {
        binding.navDrawerView.setNavigationItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                drawer.closeDrawer(Gravity.LEFT)
                when (item.itemId) {
                    R.id.navigation_drawer_home -> {
                        navController.navigate(R.id.navigation_home)
                        true
                    }

                    R.id.navigation_drawer_worker -> {
                        navController.navigate(R.id.navigation_worker)
                        true
                    }

                    R.id.navigation_drawer_history -> {
                        navController.navigate(R.id.navigation_history)
                        true
                    }

                    else -> true
                }

                return true
            }
        })

    }


    private fun navigationFragment() {
        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_contact -> {
                    navController.navigate(R.id.navigation_contact)
                    true
                }

                R.id.navigation_calendar -> {
                    navController.navigate(R.id.navigation_calendar)
                    true
                }

                R.id.navigation_home -> {
                    navController.navigate(R.id.navigation_home)
                    true
                }

                R.id.navigation_worker -> {
                    navController.navigate(R.id.navigation_worker)
                    true
                }

                R.id.navigation_history -> {
                    navController.navigate(R.id.navigation_history)
                    true
                }

                else -> {
                    true
                }
            }
        }
    }


    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish()
            return
        }
        doubleBackToExitPressedOnce = true
        tosat(this, getString(R.string.chiqish_uchun_orqaga_tugmasini_bosing))
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            doubleBackToExitPressedOnce = false
        }, 2000)
    }

    override fun drawerOnOff() {
        if (drawer.isDrawerOpen(Gravity.LEFT)) {
            drawer.closeDrawer(Gravity.LEFT)
        } else {
            drawer.openDrawer(Gravity.LEFT)
        }
    }


}


