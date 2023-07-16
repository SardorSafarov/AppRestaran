package com.example.apprestaran.activity.language


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.core.content.ContextCompat
import com.example.apprestaran.R
import com.example.apprestaran.activity.login.LoginActivity
import com.example.apprestaran.databinding.ActivityLanguageBinding

class LanguageActivity : AppCompatActivity() {
    lateinit var binding: ActivityLanguageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusbar));
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnUz.setOnClickListener {
                btnUz.setBackgroundColor(Color.parseColor("#ffff00"))
                btnRu.setBackgroundColor(Color.parseColor("#ffffff"))
            }
            btnRu.setOnClickListener {
                btnRu.setBackgroundColor(Color.parseColor("#ffff00"))
                btnUz.setBackgroundColor(Color.parseColor("#ffffff"))
            }
            btnNext.setOnClickListener {
                startActivity(Intent(this@LanguageActivity, LoginActivity::class.java))
            }
        }

    }
}