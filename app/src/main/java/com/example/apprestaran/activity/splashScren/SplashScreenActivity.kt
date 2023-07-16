package com.example.apprestaran.activity.splashScren

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.content.ContextCompat
import com.example.apprestaran.MainActivity
import com.example.apprestaran.R
import com.example.apprestaran.activity.language.LanguageActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusbar));
        setContentView(R.layout.activity_splash_screen)
        object : CountDownTimer(2000,3500){
            override fun onTick(p0: Long) {}
            override fun onFinish() {
                startActivity(Intent(this@SplashScreenActivity, LanguageActivity::class.java))
                finish()
            }
        }.start()
    }
}