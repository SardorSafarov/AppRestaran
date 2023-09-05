package com.example.apprestaran.activity.departments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityProductBinding
class ProductActivity : AppCompatActivity() {
    lateinit var binding:ActivityProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnExit.setOnClickListener {
            finish()
        }
    }
}