package com.example.apprestaran.activity.departments.worker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityCookBinding
import com.example.apprestaran.databinding.DialogWorkerCookeAddBinding
import com.example.apprestaran.databinding.DialogWorkerOfisantAddBinding

class CookActivity : AppCompatActivity() {
    lateinit var binding:ActivityCookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnExit.setOnClickListener {
            finish()
        }
        addCookeDialog()
    }
    private fun addCookeDialog() {
        binding.btnAddCooke.setOnClickListener {
            val builder = AlertDialog.Builder(this, R.style.CustomDialogTheme)
            val inflater = layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_worker_cooke_add, null)
            val bindingDialog = DialogWorkerCookeAddBinding.bind(dialogView)
            builder.setView(dialogView)
            val dialog = builder.create()
            dialog.show()
            bindingDialog.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}