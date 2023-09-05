package com.example.apprestaran.activity.adminPanel.ui.home

import android.app.ActivityOptions
import android.content.Intent
import com.example.apprestaran.activity.departments.ProductActivity
import com.example.apprestaran.activity.departments.WearHouseProductActivity
import com.example.apprestaran.databinding.FragmentHomeBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment


class HomeFragment() : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun onViewCreate() {
        binding.textAdminName.text = sharePereferenseHelper.getAdminName()
        btnClickListener()

    }

    private fun btnClickListener() {
        binding.apply {

            btnHamburger.setOnClickListener {
                listener!!.drawerOnOff()
            }
            btnProduct.setOnClickListener {
                var anim = ActivityOptions.makeSceneTransitionAnimation(requireActivity()).toBundle()
                var i = Intent(requireContext(), ProductActivity::class.java)
                startActivity(i, anim)
            }
            btnWorker.setOnClickListener {
              listener!!.worker()
            }
            btnWarehouse.setOnClickListener {
                var anim = ActivityOptions.makeSceneTransitionAnimation(requireActivity()).toBundle()
                var i = Intent(requireContext(), WearHouseProductActivity::class.java)
                startActivity(i, anim)
            }
            btnReport.setOnClickListener {
                listener!!.report()
            }
        }

    }


}