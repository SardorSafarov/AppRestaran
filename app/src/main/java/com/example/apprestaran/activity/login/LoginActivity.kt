package com.example.apprestaran.activity.login

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.core.content.ContextCompat
import com.example.apprestaran.R
import com.example.apprestaran.activity.adminPanel.AdminRegisterActivity
import com.example.apprestaran.databinding.ActivityLoginBinding
import com.example.apprestaran.mask.PhoneNumberTextWatcher
import com.example.apprestaran.need.d


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private var linear1 = true
    private var linear2 = true
    private var passwordAdmin = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar));
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnClickListener()
        binding.edtPhoneNumber.addTextChangedListener(
            PhoneNumberTextWatcher(
                binding.edtPhoneNumber,
                "uz"
            )
        )
    }

    private fun btnClickListener() {

        cardView()
        passwordShowNotShow()
        openCountryCode()
    }


    @SuppressLint("RestrictedApi")
    private fun openCountryCode() {
        binding.apply {
            btnCountryCode.setOnClickListener {
                var it = it as View
                val menuBuilder = MenuBuilder(this@LoginActivity)
                val inflater = MenuInflater(this@LoginActivity)
                inflater.inflate(R.menu.country_code, menuBuilder)

                val optionsMenu = MenuPopupHelper(this@LoginActivity, menuBuilder, it)
                optionsMenu.setForceShowIcon(true)
                menuBuilder.setCallback(object : MenuBuilder.Callback {
                    override fun onMenuItemSelected(menu: MenuBuilder, item: MenuItem): Boolean {
                        when (item.itemId) {
                            R.id.uz -> {
                                imgCountryFlag.setImageResource(R.drawable.flag_uz)
                                textCountryCode.text = item.title
                                binding.edtPhoneNumber.hint = "00 000 00 00"
                                binding.apply {
                                    edtPhoneNumber.text.clear()
                                    edtPhoneNumber.addTextChangedListener(
                                        PhoneNumberTextWatcher(
                                            binding.edtPhoneNumber,
                                            "uz"
                                        )
                                    )

                                }

                            }

                            R.id.ru -> {
                                imgCountryFlag.setImageResource(R.drawable.flag_ru)
                                textCountryCode.text = item.title
                                binding.edtPhoneNumber.hint = "000 000 0000"
                                binding.apply {
                                    edtPhoneNumber.text.clear()
                                    edtPhoneNumber.addTextChangedListener(
                                        PhoneNumberTextWatcher(
                                            binding.edtPhoneNumber,
                                            "ru"
                                        )
                                    )

                                }
                            }

                            R.id.turkiya -> {
                                imgCountryFlag.setImageResource(R.drawable.flag_turkiya)
                                textCountryCode.text = item.title
                            }

                            R.id.azarbayjan -> {
                                imgCountryFlag.setImageResource(R.drawable.flag_azarbayjan)
                                textCountryCode.text = item.title
                            }

                            else -> false
                        }
                        return true
                    }

                    override fun onMenuModeChange(menu: MenuBuilder) {}
                })
                optionsMenu.show()
            }

        }
    }


    private fun passwordShowNotShow() {
        binding.apply {
            btnPasswordShow.setOnClickListener {

                if (passwordAdmin) {
                    edtPasswordAdmin.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                    imgEye.setImageResource(R.drawable.baseline_visibility_on)
                } else {
                    edtPasswordAdmin.setTransformationMethod(PasswordTransformationMethod.getInstance())

                    imgEye.setImageResource(R.drawable.baseline_visibility_off_24)
                }
                binding.edtPasswordAdmin.setSelection(binding.edtPasswordAdmin.length())
                passwordAdmin = !passwordAdmin

            }
        }
    }

    private fun cardView() {
        binding.apply {
            btnLinear1.setOnClickListener {
                if (linear1) {
                    TransitionManager.beginDelayedTransition(btnLinear1, AutoTransition())
                    line1.visibility = View.VISIBLE


                } else {
                    line1.visibility = View.GONE
                    TransitionManager.beginDelayedTransition(btnLinear1, AutoTransition())
                }

                img1.rotation = if (linear1) 90f else -90f
                linear1 = !linear1
            }
            btnLinear2.setOnClickListener {
                if (linear2) {
                    TransitionManager.beginDelayedTransition(btnLinear2, AutoTransition())
                    line2.visibility = View.VISIBLE
                } else {
                    line2.visibility = View.GONE
                    TransitionManager.beginDelayedTransition(btnLinear2, AutoTransition())
                }
                img2.rotation = if (linear2) 90f else -90f
                linear2 = !linear2
            }

            btnRegister.setOnClickListener {
                var i = Intent(this@LoginActivity, AdminRegisterActivity::class.java)
                var anim = ActivityOptions.makeSceneTransitionAnimation(this@LoginActivity).toBundle()
                startActivity(i,anim)
            }
        }
    }
}