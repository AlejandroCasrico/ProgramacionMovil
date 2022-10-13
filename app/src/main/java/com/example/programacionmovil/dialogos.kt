package com.example.programacionmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class dialogos : AppCompatActivity() {
    lateinit var btnShowDialog: Button
    lateinit var btnCancelLoginDialog: Button
    lateinit var btnLoginGialog:Button
    lateinit var  txtNameDialog: EditText
    lateinit var txtEmailDialog: EditText
   lateinit var  txtPasswordDialog:EditText
    lateinit var txtActivityValues:TextView
    lateinit var btnDialogImage:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogos)

        val btnDialog:Button= findViewById(R.id.showDialog)
        val btnDImage:Button= findViewById(R.id.dialogImage)

        btnDImage.setOnClickListener{
            val dialogView = layoutInflater.inflate(R.layout.dialog_image,null)
            AlertDialog.Builder(this).setView(dialogView).setTitle("Image")
        }

    }
}