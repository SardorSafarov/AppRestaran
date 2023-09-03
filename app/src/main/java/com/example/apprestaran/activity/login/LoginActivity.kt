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
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import com.example.apprestaran.R
import com.example.apprestaran.activity.adminPanel.AdminMainActivity
import com.example.apprestaran.activity.adminPanel.AdminRegisterActivity
import com.example.apprestaran.activity.pinCode.PinCodeActivity
import com.example.apprestaran.databinding.ActivityLoginBinding
import com.example.apprestaran.mask.PhoneNumberTextWatcher
import com.example.apprestaran.need.d
import com.example.apprestaran.need.passwordShowOnOFF
import com.example.apprestaran.need.tosat
import com.example.apprestaran.need.visbleAndGone


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private var linear11 = true
    private var linear22 = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar));
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnClickListener()
        binding.edtAdminPhoneNumber.addTextChangedListener(
            PhoneNumberTextWatcher(
                binding.edtAdminPhoneNumber,
                "uz"
            )
        )
    }

    private fun btnClickListener() {
        cardView()
        passwordShowNotShow()
        openCountryCode()
    }

    private fun cardView() {
        binding.apply {
            cardOpenClose()
            btnAdminNext.setOnClickListener {
                var validator = validationData()
                if (validator == "ok") {
                    var i = Intent(this@LoginActivity, PinCodeActivity::class.java)
                    var anim = ActivityOptions.makeSceneTransitionAnimation(this@LoginActivity).toBundle()
                    startActivity(i, anim)
                } else {
                    tosat(this@LoginActivity, message = validator)
                }
            }
            btnAdminRegister.setOnClickListener {
                var i = Intent(this@LoginActivity, AdminRegisterActivity::class.java)
                var anim = ActivityOptions.makeSceneTransitionAnimation(this@LoginActivity).toBundle()
                startActivity(i, anim)
            }

        }
    }

    private fun cardOpenClose() {
        binding.apply {
            btnAdminLinear.setOnClickListener {
                linear1.visbleAndGone()
                img1.rotation = if (linear11) 90f else -90f
                linear11 = !linear11
            }
            btnLinear2.setOnClickListener {
                linear2.visbleAndGone()
                img2.rotation = if (linear22) 90f else -90f
                linear22 = !linear22
            }
        }
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
                                binding.edtAdminPhoneNumber.hint = "00 000 00 00"
                                binding.apply {
                                    edtAdminPhoneNumber.text.clear()
                                    edtAdminPhoneNumber.addTextChangedListener(
                                        PhoneNumberTextWatcher(
                                            binding.edtAdminPhoneNumber,
                                            "uz"
                                        )
                                    )

                                }

                            }

                            R.id.ru -> {
                                imgCountryFlag.setImageResource(R.drawable.flag_ru)
                                textCountryCode.text = item.title
                                binding.edtAdminPhoneNumber.hint = "000 000 0000"
                                binding.apply {
                                    edtAdminPhoneNumber.text.clear()
                                    edtAdminPhoneNumber.addTextChangedListener(
                                        PhoneNumberTextWatcher(
                                            binding.edtAdminPhoneNumber,
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
                passwordShowOnOFF(this@LoginActivity, imgEye, edtAdminPassword)
            }
        }
    }


    private fun validationData(): String {
        binding.apply {
            if (edtAdminPhoneNumber.text.length!=edtAdminPhoneNumber.hint.length)
                return getString(R.string.telefon_nomerni_to_liq_kiriting)
            if (edtAdminPassword.text!!.isEmpty())
                return getString(R.string.parolni_kiriting)
        }
        return "ok"
    }
}