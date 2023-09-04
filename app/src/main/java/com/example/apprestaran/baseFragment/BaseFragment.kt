package com.example.e_kengash.main.fragments.baseFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.example.apprestaran.activity.adminPanel.ui.DrawerOnOffInteface
import com.example.apprestaran.localMemory.SharePereferenseHelper


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {
    private var _binding: VB? = null
    val binding get() = _binding!!
    lateinit var navController: NavController
    lateinit var sharePereferenseHelper: SharePereferenseHelper
    var listener: DrawerOnOffInteface? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharePereferenseHelper = SharePereferenseHelper(requireContext())
        _binding = inflate.invoke(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        onViewCreate()
    }
    abstract fun onViewCreate()
    operator fun VB.invoke(body: VB.() -> Unit) = this.apply { body() }
    override fun onAttach(context: Context) {
        super.onAttach(requireContext())
        listener = context as DrawerOnOffInteface?
    }

}