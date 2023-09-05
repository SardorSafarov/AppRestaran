package com.example.apprestaran.activity.adminPanel.ui.worker

import android.app.ActivityOptions
import android.content.Intent
import androidx.core.view.ViewCompat
import com.example.apprestaran.activity.departments.worker.AccountantActivity
import com.example.apprestaran.activity.departments.worker.CookActivity
import com.example.apprestaran.activity.departments.worker.ManagersActivity
import com.example.apprestaran.activity.departments.worker.OfitsantsActivity
import com.example.apprestaran.activity.departments.worker.TablesActivity
import com.example.apprestaran.activity.departments.worker.WarehouseWorkerActivity
import com.example.apprestaran.databinding.FragmentWorkerBinding
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment


class WorkerFragment : BaseFragment<FragmentWorkerBinding>(FragmentWorkerBinding::inflate) {
    override fun onViewCreate() {
        binding.btnHamburger.setOnClickListener {
            listener!!.drawerOnOff()
        }
        bntClickListener()
    }

    private fun bntClickListener() {
        binding.apply {
            btnOfisant.setOnClickListener{
                var i = Intent(requireContext(), OfitsantsActivity::class.java)
                var anim = ActivityOptions.makeSceneTransitionAnimation(requireActivity()).toBundle()
                startActivity(i, anim)
            }
            btnCooke.setOnClickListener {
                var i = Intent(requireContext(), CookActivity::class.java)
                var anim =
                    ActivityOptions.makeSceneTransitionAnimation(requireActivity()).toBundle()
                startActivity(i, anim)
            }
            btnKassr.setOnClickListener {
                var i = Intent(requireContext(), AccountantActivity::class.java)
                var anim =
                    ActivityOptions.makeSceneTransitionAnimation(requireActivity()).toBundle()
                startActivity(i, anim)
            }
            btnWarehouse.setOnClickListener {
                var i = Intent(requireContext(), WarehouseWorkerActivity::class.java)
                var anim =
                    ActivityOptions.makeSceneTransitionAnimation(requireActivity()).toBundle()
                startActivity(i, anim)
            }
            btnManager.setOnClickListener {
                var i = Intent(requireContext(), ManagersActivity::class.java)
                var anim =
                    ActivityOptions.makeSceneTransitionAnimation(requireActivity()).toBundle()
                startActivity(i, anim)
            }
            btnTabele.setOnClickListener {
                var i = Intent(requireContext(), TablesActivity::class.java)
                var anim =
                    ActivityOptions.makeSceneTransitionAnimation(requireActivity()).toBundle()
                startActivity(i, anim)
            }
        }
    }
}