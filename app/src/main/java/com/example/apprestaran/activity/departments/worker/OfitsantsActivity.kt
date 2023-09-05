package com.example.apprestaran.activity.departments.worker

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityOfitsantsBinding
import com.example.apprestaran.databinding.DialogProductDepartamenAddBinding
import com.example.apprestaran.databinding.DialogWorkerOfisantAddBinding

class OfitsantsActivity : AppCompatActivity() {
    lateinit var binding: ActivityOfitsantsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOfitsantsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnExit.setOnClickListener {
            finish()
        }
        btnClickListener()
    }

    private fun btnClickListener() {
        addOfisantDialog()
    }

    private fun addOfisantDialog() {
        binding.btnAddOfisant.setOnClickListener {
            val builder = AlertDialog.Builder(this, R.style.CustomDialogTheme)
            val inflater = layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_worker_ofisant_add, null)
            val bindingDialog = DialogWorkerOfisantAddBinding.bind(dialogView)
            builder.setView(dialogView)
            val dialog = builder.create()
            dialog.show()
            bindingDialog.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}