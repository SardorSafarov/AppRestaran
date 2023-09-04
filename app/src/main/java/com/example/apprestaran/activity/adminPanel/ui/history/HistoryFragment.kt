package com.example.apprestaran.activity.adminPanel.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apprestaran.R
import com.example.apprestaran.databinding.FragmentHistoryBinding
import com.example.apprestaran.databinding.FragmentHomeBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment


class HistoryFragment :  BaseFragment<FragmentHistoryBinding>(FragmentHistoryBinding::inflate) {
    override fun onViewCreate() {
        binding.btnHamburger.setOnClickListener {
            listener!!.drawerOnOff()
        }
    }

}