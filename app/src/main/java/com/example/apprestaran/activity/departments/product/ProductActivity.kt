package com.example.apprestaran.activity.departments.product

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apprestaran.R
import com.example.apprestaran.activity.adminPanel.AdminRegisterActivity
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
        binding.btnProductDerartament.setOnClickListener {
            var i = Intent(this@ProductActivity, ProductAddDepartamensActivity::class.java)
            var anim = ActivityOptions.makeSceneTransitionAnimation(this@ProductActivity).toBundle()
            startActivity(i, anim)
        }
        binding.btnAddProduct.setOnClickListener {
            var i = Intent(this@ProductActivity, ProductAddActivity::class.java)
            var anim = ActivityOptions.makeSceneTransitionAnimation(this@ProductActivity).toBundle()
            startActivity(i, anim)
        }
    }
}