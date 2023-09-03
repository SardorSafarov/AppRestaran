package com.example.apprestaran.activity.adminPanel

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.core.content.ContextCompat
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityAdminRegisterBinding
import com.example.apprestaran.mask.PhoneNumberTextWatcher
import com.example.apprestaran.need.d

class AdminRegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdminRegisterBinding
    var passwordAdmin1 = true
    var passwordAdmin2 = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar))
        binding = ActivityAdminRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnSetOnClikListener()
        binding.edtPhoneNumber.addTextChangedListener(PhoneNumberTextWatcher(binding.edtPhoneNumber))
    }

    private fun btnSetOnClikListener() {
        binding.btnNext1.setOnClickListener {
            Intent(this@AdminRegisterActivity, AdminMainActivity::class.java)
        }
        openCountryCode()
        passwordShowNotShow()
    }

    @SuppressLint("RestrictedApi")
    private fun openCountryCode() {
        binding.apply {
            btnCountryCode.setOnClickListener {
                var it = it as View
                val menuBuilder = MenuBuilder(this@AdminRegisterActivity)
                val inflater = MenuInflater(this@AdminRegisterActivity)
                inflater.inflate(R.menu.country_code, menuBuilder)

                val optionsMenu = MenuPopupHelper(this@AdminRegisterActivity, menuBuilder, it)
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
            btnPasswordShow1.setOnClickListener {

                if (passwordAdmin1) {
                    edtPassword1.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                    imgEye1.setImageResource(R.drawable.baseline_visibility_on)
                } else {
                    edtPassword1.setTransformationMethod(PasswordTransformationMethod.getInstance())

                    imgEye1.setImageResource(R.drawable.baseline_visibility_off_24)
                }
                binding.edtPassword1.setSelection(binding.edtPassword1.length())
                passwordAdmin1 = !passwordAdmin1

            }
            btnPasswordShow2.setOnClickListener {

                if (passwordAdmin2) {
                    edtPassword2.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                    imgEye2.setImageResource(R.drawable.baseline_visibility_on)
                } else {
                    edtPassword2.setTransformationMethod(PasswordTransformationMethod.getInstance())

                    imgEye2.setImageResource(R.drawable.baseline_visibility_off_24)
                }
                binding.edtPassword2.setSelection(binding.edtPassword2.length())
                passwordAdmin2 = !passwordAdmin2

            }
        }
    }
}