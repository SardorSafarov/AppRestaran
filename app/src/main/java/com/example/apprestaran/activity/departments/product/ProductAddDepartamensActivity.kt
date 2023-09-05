package com.example.apprestaran.activity.departments.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityProductAddDepartamensBinding
import com.example.apprestaran.databinding.ActivityProductBinding
import com.example.apprestaran.databinding.DialogProductDepartamenAddBinding
import com.example.apprestaran.need.d

class ProductAddDepartamensActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductAddDepartamensBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductAddDepartamensBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnClickLisntener()

    }

    private fun btnClickLisntener() {
        binding.btnExit.setOnClickListener { finish() }
        addDepartamen()
    }

    private fun addDepartamen() {
        binding.btnAddDerartament.setOnClickListener {
            val builder = AlertDialog.Builder(this,R.style.CustomDialogTheme)
            val inflater = layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_product_departamen_add, null)
            val bindingDialog = DialogProductDepartamenAddBinding.bind(dialogView)
            builder.setView(dialogView)
            val dialog = builder.create()
            dialog.show()
            bindingDialog.btnDepartamentAdd.setOnClickListener {
                dialog.dismiss()
            }


        }
    }
}