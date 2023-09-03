package com.example.apprestaran.activity.pinCode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.apprestaran.R
import com.example.apprestaran.activity.adminPanel.AdminMainActivity
import com.example.apprestaran.databinding.ActivityCheckPinCodeBinding
import com.example.apprestaran.localMemory.SharePereferenseHelper
import com.example.apprestaran.need.gone
import com.example.apprestaran.need.invisible
import com.example.apprestaran.need.tosat
import com.example.apprestaran.need.visible

class CheckPinCodeActivity : AppCompatActivity() {
    lateinit var textViewList: MutableList<TextView>
    lateinit var pinCode:String
    lateinit var sharePereferenseHelper: SharePereferenseHelper
    lateinit var binding:ActivityCheckPinCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckPinCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnClickListener()
        checkAndRemovePinCode()
        sharePereferenseHelper = SharePereferenseHelper(this)
        pinCode = sharePereferenseHelper.getPinCode()
    }
    private fun btnClickListener() {
        binding.apply {
            btn1.setOnClickListener {
                pinCodeWrite(it)
            }
            btn2.setOnClickListener {
                pinCodeWrite(it)
            }
            btn3.setOnClickListener {
                pinCodeWrite(it)
            }
            btn4.setOnClickListener {
                pinCodeWrite(it)
            }
            btn5.setOnClickListener {
                pinCodeWrite(it)
            }
            btn6.setOnClickListener {
                pinCodeWrite(it)
            }
            btn7.setOnClickListener {
                pinCodeWrite(it)
            }
            btn8.setOnClickListener {
                pinCodeWrite(it)
            }
            btn9.setOnClickListener {
                pinCodeWrite(it)
            }
            btn0.setOnClickListener {
                pinCodeWrite(it)
            }
            btnPinCodeShowOnOff.setOnClickListener {
                if (btnPinCodeShowOnOff.getDrawable().constantState == resources.getDrawable(R.drawable.baseline_visibility_on).constantState) {
                    btnPinCodeShowOnOff.setImageResource(R.drawable.baseline_visibility_off_24)
                    pinCodeTextShowOnOff(R.drawable.baseline_visibility_off_24)
                } else {
                    btnPinCodeShowOnOff.setImageResource(R.drawable.baseline_visibility_on)
                    pinCodeTextShowOnOff(R.drawable.baseline_visibility_on)
                }
            }
        }
    }

    private fun pinCodeTextShowOnOff(baselineVisibilityOff24: Int) {
        if (baselineVisibilityOff24 ==R.drawable.baseline_visibility_off_24){
            textViewList.forEach {
                it.setBackgroundResource(R.drawable.bg_pin_code_text_off)
            }
        }else{
            textViewList.forEach {
                it.setBackgroundResource(R.drawable.bg_pin_code_text_on)
            }
        }
    }

    private fun checkAndRemovePinCode() {
        binding.apply {
            textViewList = mutableListOf(text1, text2, text3, text4)
        }

        binding.btnClear.setOnClickListener {
            for (i in 3 downTo 0) {
                if (textViewList[i].text.isNotEmpty()) {
                    textViewList[i].text = ""
                    textViewList[i].gone()
                    if (i == 0)
                        binding.btnClear.invisible()
                    return@setOnClickListener
                }
            }
        }
    }

    private fun pinCodeWrite(view: View) {
        var btn = view as AppCompatButton
        textViewList.forEach {
            if (it.text.isEmpty()) {
                it.text = btn.text.toString()
                it.visible()
                repetatPinCodeGo()
                binding.btnClear.visible()
                return
            }
        }
    }

    private fun repetatPinCodeGo() {
        var newPinCode = ""
        textViewList.forEach {
            if (it.text.isNotEmpty())
                newPinCode+=it.text.toString()
        }
        if (newPinCode.length==4)
        {
            if (newPinCode==pinCode){
                sharePereferenseHelper.setPinCode(pinCode)
                var i = Intent(this, AdminMainActivity::class.java)
                startActivity(i)
                finish()
            }
            else{
                tosat(this, getString(R.string.kiritilgan_ma_lumot_mos_kelmaydi))
            }

        }
    }
}