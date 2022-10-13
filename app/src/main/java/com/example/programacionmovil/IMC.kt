package com.example.programacionmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class IMC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        val height: EditText= findViewById(R.id.peso)
        val widht: EditText= findViewById(R.id.estatura)
        val btnCalcular: Button =findViewById(R.id.calcular)


        btnCalcular.setOnClickListener(){
            if( widht.text.isEmpty() && height.text.isEmpty()){
                Toast.makeText(this,"debe llenar los campos", Toast.LENGTH_LONG).show()
            }else{


            val pesoEnKg= widht.text.toString().toDouble()
            val estaturaEnMts= height.text.toString().toDouble()
            val estatusDelPaciente= pesoEnKg/(estaturaEnMts*estaturaEnMts)
            if(estatusDelPaciente >=19&& estatusDelPaciente<=24.9){
                Toast.makeText(this,"el paciente se encuentra saludable", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"el paciente no esta saludable", Toast.LENGTH_LONG).show()
            }
        }
        }
    }
}