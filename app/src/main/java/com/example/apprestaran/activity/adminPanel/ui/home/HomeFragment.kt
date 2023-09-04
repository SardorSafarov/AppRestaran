package com.example.apprestaran.activity.adminPanel.ui.home

import android.content.Context
import com.example.apprestaran.activity.adminPanel.ui.DrawerOnOffInteface
import com.example.apprestaran.databinding.FragmentHomeBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment


class HomeFragment() : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun onViewCreate() {
        binding.textAdminName.text = sharePereferenseHelper.getAdminName()
        binding.btnHamburger.setOnClickListener {
          listener!!.drawerOnOff()
        }
    }






}