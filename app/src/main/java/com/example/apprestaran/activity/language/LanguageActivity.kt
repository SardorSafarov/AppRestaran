package com.example.apprestaran.activity.language


import android.app.ActivityOptions
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.apprestaran.R
import com.example.apprestaran.activity.login.LoginActivity
import com.example.apprestaran.databinding.ActivityLanguageBinding
import com.example.apprestaran.`fun`.D
import com.example.apprestaran.localMemory.SharePereferenseHelper
import com.example.apprestaran.need.tosat
import java.util.Locale

class LanguageActivity : AppCompatActivity() {
    lateinit var binding: ActivityLanguageBinding
    private var language = ""
    private lateinit var sharePereferenseHelper: SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusbar));
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePereferenseHelper = SharePereferenseHelper(this)
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
                    setLanguage(language)
                    sharePereferenseHelper.setAppLanguage(language)
                    var anim = ActivityOptions.makeSceneTransitionAnimation(this@LanguageActivity).toBundle()
                    startActivity(Intent(this@LanguageActivity, LoginActivity::class.java),anim)
                }

            }
        }

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