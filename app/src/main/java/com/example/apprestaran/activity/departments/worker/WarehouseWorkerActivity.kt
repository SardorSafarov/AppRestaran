package com.example.apprestaran.activity.departments.worker

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityWarehouseWorkerBinding
import com.example.apprestaran.databinding.DialogWorkerWarehouseAddBinding

class WarehouseWorkerActivity : AppCompatActivity() {
    lateinit var binding: ActivityWarehouseWorkerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWarehouseWorkerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnExit.setOnClickListener {
            finish()
        }

        addWarehouseDialog()

    }

    private fun addWarehouseDialog() {
        binding.btnAddWarehouse.setOnClickListener {
            val builder = AlertDialog.Builder(this, R.style.CustomDialogTheme)
            val inflater = layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_worker_warehouse_add, null)
            val bindingDialog = DialogWorkerWarehouseAddBinding.bind(dialogView)
            builder.setView(dialogView)
            val dialog = builder.create()
            dialog.show()
            bindingDialog.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}