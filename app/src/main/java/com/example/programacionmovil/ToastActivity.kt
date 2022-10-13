package com.example.programacionmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        val btnShortDuration: Button = findViewById(R.id.btnShowToast)
        btnShortDuration.setOnClickListener(){
            Toast.makeText( this,"Mi toast corto",Toast.LENGTH_SHORT).show()
        }
        val btnLongDuration: Button = findViewById(R.id.largo)
        btnLongDuration.setOnClickListener(){
            val name = "Alex"
            Toast.makeText(this,"$name",Toast.LENGTH_LONG).show()
        }
    }
}