package com.example.apprestaran.activity.departments.worker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityAccountantBinding
import com.example.apprestaran.databinding.DialogWorkerKassirAddBinding
import com.example.apprestaran.databinding.DialogWorkerOfisantAddBinding

class AccountantActivity : AppCompatActivity() {
    lateinit var binding:ActivityAccountantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnExit.setOnClickListener {
            finish()
        }
        addKassirDialog()
    }
    private fun addKassirDialog() {
        binding.btnAddKassir.setOnClickListener {
            val builder = AlertDialog.Builder(this, R.style.CustomDialogTheme)
            val inflater = layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_worker_kassir_add, null)
            val bindingDialog = DialogWorkerKassirAddBinding.bind(dialogView)
            builder.setView(dialogView)
            val dialog = builder.create()
            dialog.show()
            bindingDialog.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}