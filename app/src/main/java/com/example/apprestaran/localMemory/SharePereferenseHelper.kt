package com.example.apprestaran.localMemory

import android.content.Context
import android.content.SharedPreferences


class SharePereferenseHelper(val context: Context) {

    private var preferences: SharedPreferences =
        context.getSharedPreferences("App", Context.MODE_PRIVATE)
    private lateinit var editor: SharedPreferences.Editor

//    fun setAccessToken(token: String) {
//        editor = preferences.edit()
//        editor.putString(ACCESS_TOKEN, token)
//        editor.apply()
//    }
//
//    fun getAccessToken() = preferences.getString(ACCESS_TOKEN, "empty").toString()
//
//    fun setAccessLanguage(language: String) {
//        editor = preferences.edit()
//        editor.putString(LANGUAGE, language)
//        editor.apply()
//    }
//
//    fun getAccessLenguage() = preferences.getString(LANGUAGE, "uz").toString()
//
//
//
//    fun setAccessPhone(phone: String) {
//        editor = preferences.edit()
//        editor.putString(PHONE, phone)
//        editor.apply()
//    }
//
//    fun getAccessPhone() = preferences.getString(PHONE, "empty").toString()

    fun setAccessDeputatId(phone: String) {
        editor = preferences.edit()
        editor.putString("deputatId", phone)
        editor.apply()
    }

    fun getAccessDeputatId() = preferences.getString("deputatId", "empty").toString()

    fun setAccessDomen1(phone: String) {
        editor = preferences.edit()
        editor.putString("domen1", phone)
        editor.apply()
    }

    fun getAccessDomen1() = preferences.getString("domen1", "empty").toString()

    fun setAccessDomen2(phone: String) {
        editor = preferences.edit()
        editor.putString("domen2", phone)
        editor.apply()
    }

    fun getAccessDomen2() = preferences.getString("domen2", "empty").toString()


}