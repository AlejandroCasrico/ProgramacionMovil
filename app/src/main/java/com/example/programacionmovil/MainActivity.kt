package com.example.programacionmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button = findViewById(R.id.btn)
        val button2: Button = findViewById(R.id.btn2)

        val btnShowToastView : Button = findViewById(R.id.ToastActivity)
        val btnIMC :Button= findViewById(R.id.imc)
        val btn :Button= findViewById(R.id.btnjuego)
        val btnanim: Button= findViewById(R.id.btnanim)
        val juego2: Button= findViewById(R.id.piedraypapel)
        val geoquizb:Button= findViewById(R.id.geo)
        val bottonqt: Button= findViewById(R.id.Qrbtn)
        val btndialogo:Button= findViewById(R.id.dialogo1)
        val btnexam: Button= findViewById(R.id.segundoex)
        val btnpoke: Button= findViewById(R.id.pokemxd)

        btn1.setOnClickListener{
            Log.d("my tag","mi primer listener")

        }
        button2.setOnClickListener{

        }
        btnIMC.setOnClickListener{
            val intent=Intent(this,IMC::class.java).apply {

            }
            startActivity(intent)
        }
        btnShowToastView.setOnClickListener{
            val intent = Intent (this,IMC::class.java).apply{
            }
            startActivity(intent)
        }
        btn.setOnClickListener{
            val intent=Intent(this,juego::class.java).apply {
            }
            startActivity(intent)
        }
        btnanim.setOnClickListener{
            val intent=Intent(this,Animacion::class.java).apply {

            }
            startActivity(intent)
        }
        juego2.setOnClickListener{
            val intent=Intent(this,PaperRockScisors::class.java).apply {

            }
            startActivity(intent)
        }
        geoquizb.setOnClickListener{
            val intent=Intent(this,geoquiz::class.java).apply {

            }
            startActivity(intent)
        }
        bottonqt.setOnClickListener{
            val intent=Intent(this,qrscanner::class.java).apply {

            }
            startActivity(intent)
        }
        btndialogo.setOnClickListener{
            val intent=Intent(this,dialogos::class.java).apply {

            }
            startActivity(intent)
        }
        btnexam.setOnClickListener{
            val intent=Intent(this,Examen2parcial::class.java).apply {

            }
            startActivity(intent)
        }
        btnpoke.setOnClickListener{
            val intent=Intent(this,Pokemon::class.java).apply {

            }
            startActivity(intent)
        }
}

    }