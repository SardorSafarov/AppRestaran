package com.example.apprestaran.activity.splashScren

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.DisplayMetrics
import androidx.core.content.ContextCompat
import com.example.apprestaran.MainActivity
import com.example.apprestaran.R
import com.example.apprestaran.activity.language.LanguageActivity
import com.example.apprestaran.activity.login.LoginActivity
import com.example.apprestaran.activity.pinCode.CheckPinCodeActivity
import com.example.apprestaran.localMemory.SharePereferenseHelper
import java.util.Locale

class SplashScreenActivity : AppCompatActivity() {
    lateinit var sharePereferenseHelper: SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusbar));
        setContentView(R.layout.activity_splash_screen)
        sharePereferenseHelper = SharePereferenseHelper(this)
        setLanguage(sharePereferenseHelper.getAppLanguage())
        object : CountDownTimer(2000,3500){
            override fun onTick(p0: Long) {}
            override fun onFinish() {
                if (sharePereferenseHelper.getAppLanguage()=="empty")
                startActivity(Intent(this@SplashScreenActivity, LanguageActivity::class.java))
                if (sharePereferenseHelper.getPinCode()=="empty")
                    startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
                else
                    startActivity(Intent(this@SplashScreenActivity, CheckPinCodeActivity::class.java))
                finish()
            }
        }.start()
    }

    fun setLanguage(locale:String){
        val resources: Resources = resources
        val dm: DisplayMetrics = resources.getDisplayMetrics()
        val config: Configuration = resources.getConfiguration()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(Locale(locale.toLowerCase()))
        } else {
            config.locale = Locale(locale.toLowerCase())
        }
        resources.updateConfiguration(config, dm)
    }
}