package com.example.apprestaran.activity.language


import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.apprestaran.R
import com.example.apprestaran.activity.login.LoginActivity
import com.example.apprestaran.databinding.ActivityLanguageBinding
import com.example.apprestaran.`fun`.D
import com.example.apprestaran.need.tosat

class LanguageActivity : AppCompatActivity() {
    lateinit var binding: ActivityLanguageBinding
    private var language = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusbar));
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnUz.setOnClickListener {
                btnUz.setBackgroundColor(Color.parseColor("#ffff00"))
                btnRu.setBackgroundColor(Color.parseColor("#ffffff"))
                language="uz"
            }
            btnRu.setOnClickListener {
                btnRu.setBackgroundColor(Color.parseColor("#ffff00"))
                btnUz.setBackgroundColor(Color.parseColor("#ffffff"))
                language = "ru"
            }
            btnNext.setOnClickListener {
                if (language==""){
                   tosat(this@LanguageActivity,"Tilni tanlang\nВыберите язык")
                }else{
                    var anim = ActivityOptions.makeSceneTransitionAnimation(this@LanguageActivity).toBundle()
                    startActivity(Intent(this@LanguageActivity, LoginActivity::class.java),anim)
                }

            }
        }

    }
}