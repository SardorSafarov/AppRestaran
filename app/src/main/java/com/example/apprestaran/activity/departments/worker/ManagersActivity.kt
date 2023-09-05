package com.example.apprestaran.activity.departments.worker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityManagersBinding
import com.example.apprestaran.databinding.DialogWorkerManagerAddBinding
import com.example.apprestaran.databinding.DialogWorkerOfisantAddBinding

class ManagersActivity : AppCompatActivity() {
    lateinit var binding:ActivityManagersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManagersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnExit.setOnClickListener {
            finish()
        }
        addManagerDialog()
    }
    private fun addManagerDialog() {
        binding.btnAddManager.setOnClickListener {
            val builder = AlertDialog.Builder(this, R.style.CustomDialogTheme)
            val inflater = layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_worker_manager_add, null)
            val bindingDialog = DialogWorkerManagerAddBinding.bind(dialogView)
            builder.setView(dialogView)
            val dialog = builder.create()
            dialog.show()
            bindingDialog.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}