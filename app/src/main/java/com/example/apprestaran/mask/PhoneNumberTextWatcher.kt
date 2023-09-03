package com.example.apprestaran.mask

import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.EditText
import com.example.apprestaran.need.d


class PhoneNumberTextWatcher(private val editText: EditText,var code:String = "uz") : TextWatcher {
    var isFormatting = false
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {

        if (isFormatting) {
            return
        }
        isFormatting = true
        var text = s.toString()
            text = text.replace("[^\\d]".toRegex(), "")


            when(code){
                "uz"->{
                    val formattedNumber = StringBuilder()
                    val length = text.length
                    editText.filters = arrayOf(InputFilter.LengthFilter(12))
                    for (i in 0 until length) {
                        val c = text[i]
                        if (i == 2 || i == 5 || i == 7) {
                            formattedNumber.append(" ")
                        }
                        formattedNumber.append(c)
                        editText.removeTextChangedListener(this)
                        editText.setText(formattedNumber.toString())
                        editText.setSelection(formattedNumber.length)
                        editText.addTextChangedListener(this)
                        isFormatting = false
                    }
                }
                "ru"->{
                    val formattedNumber = StringBuilder()
                    val length = text.length
                    editText.filters = arrayOf(InputFilter.LengthFilter(12))
                    for (i in 0 until length) {
                        val c = text[i]
                        if (i == 3 || i == 6) {
                            formattedNumber.append(" ")
                        }
                        formattedNumber.append(c)
                        editText.removeTextChangedListener(this)
                        editText.setText(formattedNumber.toString())
                        editText.setSelection(formattedNumber.length)
                        editText.addTextChangedListener(this)
                        isFormatting = false
                    }
                }
            }
        }
    }
