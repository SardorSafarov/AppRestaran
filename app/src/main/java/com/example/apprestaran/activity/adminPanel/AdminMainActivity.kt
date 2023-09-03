package com.example.apprestaran.activity.adminPanel

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityAdminMainBinding
import com.example.apprestaran.need.tosat


class AdminMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminMainBinding
    private lateinit var navController: NavController
    var doubleBackToExitPressedOnce = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdminMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment_activity_admin_main)
        setupWithNavController(binding.navView, navController)
        navigationFragment()
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
            super.onBackPressed()
            return
        }
        doubleBackToExitPressedOnce = true
        tosat(this, getString(R.string.chiqish_uchun_orqaga_tugmasini_bosing))
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            doubleBackToExitPressedOnce = false
        }, 2000)
    }
}


