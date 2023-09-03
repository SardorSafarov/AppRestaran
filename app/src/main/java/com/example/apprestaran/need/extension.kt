package com.example.apprestaran.need

import android.content.Context
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import com.example.apprestaran.R

fun d(message:String){
    Log.d("sardor","---->   $message    <----")
}

fun passwordShowOnOFF(context:Context,imageView: ImageView,edtPassword:EditText){
    if (imageView.getDrawable().constantState == context.resources.getDrawable(R.drawable.baseline_visibility_on).constantState)
    {
        edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance())
        imageView.setImageResource(R.drawable.baseline_visibility_off_24)
    }
    else
    {
        edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
        imageView.setImageResource(R.drawable.baseline_visibility_on)
    }
    edtPassword.setSelection(edtPassword.length())
}