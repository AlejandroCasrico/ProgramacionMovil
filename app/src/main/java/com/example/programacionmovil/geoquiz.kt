package com.example.programacionmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.math.log

class geoquiz : AppCompatActivity() {

    private lateinit var trueButtonn : Button
    private lateinit var falseButtonn : Button
    private lateinit var nextButtonn: Button
    private lateinit var questionTextVieww: TextView

        private val questionBank=listOf(
            Question(R.string.question_australia, true),//0
            Question(R.string.question_oceans, true),//1
            Question(R.string.question_mideast, false),//2
            Question(R.string.question_africa, false),//3
            Question(R.string.question_americas, true),//4
            Question(R.string.question_asia, true),//5
        )

    private var currentIndex =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geoquiz)
        trueButtonn = findViewById(R.id.trueButton)
        falseButtonn = findViewById(R.id.falseButton)
        nextButtonn = findViewById(R.id.nextButton)
        questionTextVieww = findViewById(R.id.questionTextView)

        trueButtonn.setOnClickListener(){
            checkAnswer(true)
        }
        falseButtonn.setOnClickListener(){
            checkAnswer(false)
        }
        nextButtonn.setOnClickListener(){
           currentIndex=(currentIndex+1) % questionBank.size

            Log.d("size",questionBank.size.toString())
            Log.d("currentIndex",currentIndex.toString())
            updateQuestion()
        }
        updateQuestion()
    }
    private fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex].textReId
        questionTextVieww.setText(questionTextResId)
    }
    private fun checkAnswer (userAnswer:Boolean){
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId= if(userAnswer== correctAnswer){
            R.string.correct_toast
        }else{
            R.string.incorrect_toast
        }
        Toast.makeText(this,messageResId, Toast.LENGTH_SHORT)
            .show()

    }
}