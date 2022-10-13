package com.example.programacionmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class menu2p : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2p)
        val placabtn: Button = findViewById(R.id.placa)
        val cerrarbtn: Button = findViewById(R.id.cerrar)
        val acercabtn : Button = findViewById(R.id.acerca)


        placabtn.setOnClickListener(){
            val intent= Intent(this,qrscanner::class.java).apply {

            }
            startActivity(intent)
        }
        acercabtn.setOnClickListener(){
            val dialogView = layoutInflater.inflate(R.layout.dialog_image,null)
            AlertDialog.Builder(this).setView(dialogView).setTitle("Image")
        }


        cerrarbtn.setOnClickListener(){
            val intent= Intent(this,Examen2parcial::class.java).apply {

            }
        }

        }
    }
