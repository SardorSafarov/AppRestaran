package com.example.apprestaran.activity.departments.worker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.apprestaran.R
import com.example.apprestaran.databinding.ActivityTablesBinding
import com.example.apprestaran.databinding.DialogWorkerOfisantAddBinding
import com.example.apprestaran.databinding.DialogWorkerTableAddBinding

class TablesActivity : AppCompatActivity() {
    lateinit var binding:ActivityTablesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTablesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnExit.setOnClickListener {
            finish()
        }
        addTableDialog()
    }
    private fun addTableDialog() {
        binding.btnAddTable.setOnClickListener {
            val builder = AlertDialog.Builder(this, R.style.CustomDialogTheme)
            val inflater = layoutInflater
            val dialogView = inflater.inflate(R.layout.dialog_worker_table_add, null)
            val bindingDialog = DialogWorkerTableAddBinding.bind(dialogView)
            builder.setView(dialogView)
            val dialog = builder.create()
            dialog.show()
            bindingDialog.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}