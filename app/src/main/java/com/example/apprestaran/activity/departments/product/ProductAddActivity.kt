package com.example.apprestaran.activity.departments.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityProductAddBinding

class ProductAddActivity : AppCompatActivity() {
    lateinit var binding:ActivityProductAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnExit.setOnClickListener {
            finish()
        }
    }
}