package com.example.programacionmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class activity_sumar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sumar)
        val btnSumar: Button = findViewById(R.id.sumar)
        val pnumero: EditText = findViewById(R.id.numerop)
        val snumero: EditText= findViewById(R.id.numeros)

        btnSumar.setOnClickListener(){
            val firstNumberValue = pnumero.text.toString().toInt()
            val secondNumberValue= snumero.text.toString().toInt()
            val suma= firstNumberValue+secondNumberValue
            Toast.makeText(this,"la suma de los 2 numeros es: $suma",Toast.LENGTH_LONG)
        }
    }
}