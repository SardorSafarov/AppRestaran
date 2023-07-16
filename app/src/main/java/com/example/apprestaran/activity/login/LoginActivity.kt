package com.example.apprestaran.activity.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import com.example.apprestaran.R
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
        binding.apply {
            btnLinear1.setOnClickListener {
                if (linear1) {
                    line1.visibility = View.VISIBLE
                    line2.visibility = View.GONE
                    txt2.text = "+"
                }else{
                    line1.visibility = View.GONE
                }
                txt1.text = if(linear1) "-" else "+"
                linear1 = !linear1
            }
            btnLinear2.setOnClickListener {
                if (linear2) {
                    line2.visibility = View.VISIBLE
                    line1.visibility = View.GONE
                    txt1.text = "+"
                }else{
                    line2.visibility = View.GONE
                }
                txt2.text = if(linear2) "-" else "+"
                linear2 = !linear2
            }
        }
    }
}