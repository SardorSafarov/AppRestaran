package com.example.apprestaran.activity.adminPanel

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.core.content.ContextCompat
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityAdminRegisterBinding
import com.example.apprestaran.localMemory.SharePereferenseHelper
import com.example.apprestaran.mask.PhoneNumberTextWatcher
import com.example.apprestaran.need.passwordShowOnOFF

class AdminRegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdminRegisterBinding
    lateinit var sharePereferenseHelper: SharePereferenseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar))
        binding = ActivityAdminRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePereferenseHelper = SharePereferenseHelper(this)
        btnSetOnClikListener()
        binding.edtPhoneNumber.addTextChangedListener(PhoneNumberTextWatcher(binding.edtPhoneNumber))
    }



    private fun btnSetOnClikListener() {
        binding.btnNext.setOnClickListener {
            sharePereferenseHelper.setAdminName(binding.edtAdminName.text.toString())
            sharePereferenseHelper.setRestaranName(binding.edtRestaranName.text.toString())
            finish()
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
                passwordShowOnOFF(this@AdminRegisterActivity,imgEye1,edtPassword1)
            }
            btnPasswordShow2.setOnClickListener {
                passwordShowOnOFF(this@AdminRegisterActivity,imgEye2,edtPassword2)

            }
        }
    }
}