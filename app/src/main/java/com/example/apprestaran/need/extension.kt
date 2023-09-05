package com.example.apprestaran.need

import android.content.Context
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.LinearLayoutCompat
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



fun tosat(context: Context,message: String){
    Toast.makeText(context, "$message", Toast.LENGTH_SHORT).show()
}

fun View.visbleAndGone():View{
    if (visibility==View.GONE){
        TransitionManager.beginDelayedTransition(this as ViewGroup, AutoTransition())
        visibility = View.VISIBLE
    }else{
        visibility = View.GONE
        TransitionManager.beginDelayedTransition(this as ViewGroup, AutoTransition())
    }
    return this
}

fun View.visible():View{
    this.visibility = View.VISIBLE
    return this
}

fun View.invisible():View{
    this.visibility = View.INVISIBLE
    return this
}

fun View.gone():View{
    this.visibility = View.GONE
    return this
}
