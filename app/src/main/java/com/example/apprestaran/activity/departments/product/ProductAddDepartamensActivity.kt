package com.example.apprestaran.activity.departments.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityProductAddDepartamensBinding
import com.example.apprestaran.databinding.ActivityProductBinding

class ProductAddDepartamensActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductAddDepartamensBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductAddDepartamensBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnExit.setOnClickListener { finish() }
    }
}