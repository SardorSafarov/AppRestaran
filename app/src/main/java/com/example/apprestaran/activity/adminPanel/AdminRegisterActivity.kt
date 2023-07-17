package com.example.apprestaran.activity.adminPanel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityAdminRegisterBinding

class AdminRegisterActivity : AppCompatActivity() {
    lateinit var binding:ActivityAdminRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusbar));
        binding = ActivityAdminRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}