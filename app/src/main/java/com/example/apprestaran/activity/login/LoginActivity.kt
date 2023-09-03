package com.example.apprestaran.activity.login

import android.annotation.SuppressLint
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
import com.example.apprestaran.need.d


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private var linear1 = true
    private var linear2 = true
    private var passwordAdmin = true
    private var isFormatting = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar));
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnClickListener()
        edtPhoneNumberFormar("uz")
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
                                edtPhoneNumberFormar("uz")
                            }

                            R.id.ru -> {
                                imgCountryFlag.setImageResource(R.drawable.flag_ru)
                                textCountryCode.text = item.title
                                edtPhoneNumberFormar("ru")
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

    private fun edtPhoneNumberFormar(s: String) {

        when (s) {
            "uz" -> {
                binding.edtPhoneNumber.hint = "00 000 00 00"
                binding.edtPhoneNumber.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    }

                    override fun afterTextChanged(p0: Editable?) {

                        if (isFormatting) {
                            return
                        }
                        isFormatting = true
                        var text = p0.toString()

                        // Raqam va probelni o'chirish
                        if (text.length != 8) {
                            // Raqam va probelni o'chirish
                            text = text.replace("[^\\d]".toRegex(), "")
                            // Formatni qayta yaratish (+998 99 123 45 67)

                            // Formatni qayta yaratish (+998 99 123 45 67)
                            val formattedNumber = StringBuilder()
                            val length = text.length
                            d(length.toString())
                            for (i in 0 until length) {
                                val c = text[i]
                                if (i == 2 || i == 5 || i == 7) {
                                    formattedNumber.append(" ")
                                }
                                formattedNumber.append(c)
                            }
                            // EditText ga yangi formatlangan telefon raqamini qo'yish
                            // EditText ga yangi formatlangan telefon raqamini qo'yish
                            binding.edtPhoneNumber.removeTextChangedListener(this)
                            binding.edtPhoneNumber.setText(formattedNumber.toString())
                            binding.edtPhoneNumber.setSelection(formattedNumber.length)
                            binding.edtPhoneNumber.addTextChangedListener(this)

                            isFormatting = false
                        }else{
                            return
                        }
                    }
                })
            }
            "ru" -> {
                binding.edtPhoneNumber.hint = "000 000 0000"
                binding.edtPhoneNumber.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    }

                    override fun afterTextChanged(p0: Editable?) {

                        if (isFormatting) {
                            return
                        }
                        isFormatting = true
                        var text = p0.toString()

                        // Raqam va probelni o'chirish

                            // Raqam va probelni o'chirish
                            text = text.replace("[^\\d]".toRegex(), "")
                            // Formatni qayta yaratish (+998 99 123 45 67)

                            // Formatni qayta yaratish (+998 99 123 45 67)
                            val formattedNumber = StringBuilder()
                            val length = text.length
                            d(length.toString())
                            for (i in 0 until length) {
                                val c = text[i]
                                if (i == 3 || i == 5 || i == 8) {
                                    formattedNumber.append(" ")
                                }
                                formattedNumber.append(c)
                            }
                            // EditText ga yangi formatlangan telefon raqamini qo'yish
                            // EditText ga yangi formatlangan telefon raqamini qo'yish
                            binding.edtPhoneNumber.removeTextChangedListener(this)
                            binding.edtPhoneNumber.setText(formattedNumber.toString())
                            binding.edtPhoneNumber.setSelection(formattedNumber.length)
                            binding.edtPhoneNumber.addTextChangedListener(this)
                            isFormatting = false
                    }
                })
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
                startActivity(Intent(this@LoginActivity, AdminRegisterActivity::class.java))
            }
        }
    }
}