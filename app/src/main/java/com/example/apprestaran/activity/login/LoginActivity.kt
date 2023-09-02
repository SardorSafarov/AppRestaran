package com.example.apprestaran.activity.login

import android.content.Intent
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.apprestaran.R
import com.example.apprestaran.activity.adminPanel.AdminRegisterActivity
import com.example.apprestaran.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private var linear1 = true
    private var linear2 = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusbar));
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnClickListener()

    }

    private fun btnClickListener() {
        binding.apply {
            btnLinear1.setOnClickListener {
                if (linear1) {
                    TransitionManager.beginDelayedTransition(btnLinear1, AutoTransition())
                    line1.visibility = View.VISIBLE


                }else{
                    line1.visibility = View.GONE
                    TransitionManager.beginDelayedTransition(btnLinear1, AutoTransition())
                }
                img1.rotation = if(linear1) 90f else -90f
                linear1 = !linear1
            }
            btnLinear2.setOnClickListener {
                if (linear2) {
                    TransitionManager.beginDelayedTransition(btnLinear2, AutoTransition())
                    line2.visibility = View.VISIBLE
                }else{
                    line2.visibility = View.GONE
                    TransitionManager.beginDelayedTransition(btnLinear2, AutoTransition())
                }
                img2.rotation = if(linear2) 90f else -90f
                linear2 = !linear2
            }

            btnRegister.setOnClickListener {
                startActivity(Intent(this@LoginActivity,AdminRegisterActivity::class.java))
            }
        }


    }
}