package com.example.programacionmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

private lateinit var buttonInicio : Button
private lateinit var Imagen: ImageView
private lateinit var name: TextView
private val PokemonesBank=listOf(
    Pokemones("Articuno",R.drawable.articuno,true),
    Pokemones("Bayleef",R.drawable.bayleef,false),
    Pokemones("Beautifly",R.drawable.beautifly,false),
    Pokemones("Bonsly",R.drawable.bonsly,false),
    Pokemones("Charizard",R.drawable.charizard,false),
    Pokemones("Dewgong",R.drawable.dewgong,false),
    Pokemones("Espeon",R.drawable.espeon,false),
    Pokemones("Furret",R.drawable.furret,false),
    Pokemones("Houndoom",R.drawable.houndoom,false),
    Pokemones("Ivysour",R.drawable.ivysour,false),
    Pokemones("Lapras",R.drawable.lapras,false),
    Pokemones("Leafeon",R.drawable.leafeon,false),
    Pokemones("Lucario",R.drawable.lucario,false),
    Pokemones("Lugia",R.drawable.lugia,true),
    Pokemones("Marowak", R.drawable.marowak,false),
    Pokemones("Mewtwo",R.drawable.mewtwo,true),
    Pokemones("Munchlax",R.drawable.munchlax,false),
    Pokemones("Nidorina",R.drawable.nidorina,false),
    Pokemones("Ninetales",R.drawable.ninetales,false),
    Pokemones("Pidgeotto",R.drawable.pidgeotto,false),
    Pokemones("Snivy",R.drawable.snivy,false),
    Pokemones("Suicune",R.drawable.suicune,true),
    Pokemones("Togetic",R.drawable.togetic,false)
)

class Pokemon : AppCompatActivity() {
    private var currentIndex =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)
        buttonInicio = findViewById(R.id.inicio)
        Imagen = findViewById(R.id.imagenInicio)
        name = findViewById(R.id.nombreText)

        buttonInicio.setOnClickListener(){

            currentIndex=(currentIndex+1) % PokemonesBank.size

            Log.d("size", PokemonesBank.size.toString())
            Log.d("currentIndex",currentIndex.toString())
            updatePokemon()
        }
       updatePokemon()
    }
    private fun updatePokemon(){
        val questionTextResId = PokemonesBank[currentIndex].image
        name.setText(questionTextResId)
    }

}