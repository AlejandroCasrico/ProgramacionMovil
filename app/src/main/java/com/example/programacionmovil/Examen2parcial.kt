package com.example.programacionmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AlertDialog

class Examen2parcial : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var  password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examen2parcial)

 val btniniciar:Button=findViewById(R.id.iniciar)
        btniniciar.setOnClickListener {
            val intent: Intent = Intent(this, menu2p::class.java)
            startActivity(intent)
        }
         username = findViewById(R.id.user)
         password = findViewById(R.id.password)


        btniniciar.setOnClickListener(){
            if (username.text.toString() == "segundoparcial"&& password.toString()=="1") {
                Toast.makeText(this,"Ingreso", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Informacion equivocada",Toast.LENGTH_LONG).show()
            }

            }

        }
    }
