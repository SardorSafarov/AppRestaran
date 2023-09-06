package com.example.apprestaran.activity.adminPanel

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.apprestaran.R
import com.example.apprestaran.activity.adminPanel.ui.DrawerOnOffInteface
import com.example.apprestaran.activity.departments.product.ProductActivity
import com.example.apprestaran.activity.departments.SettingsActivity
import com.example.apprestaran.activity.departments.TarifActivity
import com.example.apprestaran.activity.departments.WearHouseProductActivity
import com.example.apprestaran.activity.login.LoginActivity
import com.example.apprestaran.databinding.ActivityAdminMainBinding
import com.example.apprestaran.localMemory.SharePereferenseHelper
import com.example.apprestaran.need.tosat
import com.google.android.material.navigation.NavigationView


class AdminMainActivity : AppCompatActivity(), DrawerOnOffInteface {

    private lateinit var binding: ActivityAdminMainBinding
    private lateinit var navController: NavController
    var doubleBackToExitPressedOnce = false
    lateinit var drawer: DrawerLayout
    lateinit var sharePereferenseHelper: SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePereferenseHelper = SharePereferenseHelper(this)
        navController = findNavController(R.id.nav_host_fragment_activity_admin_main)
        setupWithNavController(binding.navView, navController)
        navigationFragment()
        getAdminData()
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
                    R.id.nav_drawer_product->{
                        var anim = ActivityOptions.makeSceneTransitionAnimation(this@AdminMainActivity).toBundle()
                        var i = Intent(this@AdminMainActivity, ProductActivity::class.java)
                        startActivity(i,anim)
                        true
                    }
                    R.id.nav_drawer_warehouse->{
                        var anim = ActivityOptions.makeSceneTransitionAnimation(this@AdminMainActivity).toBundle()
                        var i = Intent(this@AdminMainActivity, WearHouseProductActivity::class.java)
                        startActivity(i,anim)
                        true
                    }
                    R.id.nav_drawer_tarif->{
                        var anim = ActivityOptions.makeSceneTransitionAnimation(this@AdminMainActivity).toBundle()
                        var i = Intent(this@AdminMainActivity, TarifActivity::class.java)
                        startActivity(i,anim)
                        true
                    }
                    R.id.nav_drawer_settings->{
                        var anim = ActivityOptions.makeSceneTransitionAnimation(this@AdminMainActivity).toBundle()
                        var i = Intent(this@AdminMainActivity, SettingsActivity::class.java)
                        startActivity(i,anim)
                        true
                    }
                    R.id.nav_drawer_log_out->{
                        sharePereferenseHelper.setPinCode("empty")
                        var anim = ActivityOptions.makeSceneTransitionAnimation(this@AdminMainActivity).toBundle()
                        var i = Intent(this@AdminMainActivity, LoginActivity::class.java)
                        startActivity(i,anim)
                        finishAffinity()
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

    private fun getAdminData() {
        var view =binding.navDrawerView.getHeaderView(0)
        var textAdminName = view.findViewById<TextView>(R.id.text_admin_name)
        var textAdminPoneNumber = view.findViewById<TextView>(R.id.text_admin_phone_number)
        textAdminName.text = sharePereferenseHelper.getAdminName()
        textAdminPoneNumber.text = sharePereferenseHelper.getAdminPhoneNumber()
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

    override fun worker() {
        navController.navigate(R.id.navigation_worker)
    }

    override fun report() {
        navController.navigate(R.id.navigation_history)
    }

    override fun drawerOnOff() {
        if (drawer.isDrawerOpen(Gravity.LEFT)) {
            drawer.closeDrawer(Gravity.LEFT)
        } else {
            drawer.openDrawer(Gravity.LEFT)
        }
    }


}


