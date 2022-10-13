package com.example.programacionmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Dialog : AppCompatActivity() {
    private lateinit var  txtResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        txtResult = findViewById(R.id.txtQrCodeResult)
        val qrCodeValue = intent.getStringExtra("qrCodeValue")

        txtResult.text = qrCodeValue
    }
}