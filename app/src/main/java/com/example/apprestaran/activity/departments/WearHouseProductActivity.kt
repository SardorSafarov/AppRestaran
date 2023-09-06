package com.example.apprestaran.activity.departments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityWearHouseBinding

class WearHouseProductActivity : AppCompatActivity() {
    lateinit var binding:ActivityWearHouseBinding
    lateinit var drawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWearHouseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawer = binding.drawerLayout
        btnClikListener()
    }

    private fun btnClikListener() {
        binding.btnExit.setOnClickListener {
            finish()
        }
        openNavDrawer()
    }

    private fun openNavDrawer() {
        binding.btnHamburger.setOnClickListener {
            if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                drawer.closeDrawer(Gravity.RIGHT)
            } else {
                drawer.openDrawer(Gravity.RIGHT)
            }
        }
    }
}