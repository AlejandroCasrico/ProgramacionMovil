package com.example.programacionmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.media.MediaPlayer


class juego : AppCompatActivity() {
    internal lateinit var button1 : Button
    internal lateinit var txtScore: TextView
    internal lateinit var txtTimeLeft : TextView

    var score:Int=0


    private var startMusic: MediaPlayer?=null
    lateinit var  countDownTimer: CountDownTimer
    var initialCountDown: Long =8500
    val countDownInterval :Long =500


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        val BounceAnimation= AnimationUtils.loadAnimation(this,R.anim.bounce)
        val shakeAnimation = AnimationUtils.loadAnimation(this,R.anim.shake)
        button1= findViewById(R.id.button1)
        txtScore = findViewById(R.id.txtScore)
        txtTimeLeft = findViewById(R.id.txtTimeLeft)
        val initialCountDownSeconds =initialCountDown/1000
        txtTimeLeft.text =getString(R.string.time_left,initialCountDownSeconds.toString())
        txtScore.text= getString(R.string.score,score.toString())

        initTimer()
        button1.setOnClickListener{
            it.startAnimation(BounceAnimation)
            txtScore.startAnimation(shakeAnimation)
            if(score==0){
                countDownTimer.start()
                startMusic = MediaPlayer.create(this,R.raw.what)
                startMusic?.start()
            }
            incrementScore()
        }
    }

    private fun incrementScore(){
        score++
        val newScore: String = getString(R.string.score,score.toString())
        txtScore.text =newScore
    }
    private fun initTimer(){
        countDownTimer= object:CountDownTimer(initialCountDown,countDownInterval){
                override fun  onTick(MillisUntilFinished :Long){
                    val timeLeft:Long =MillisUntilFinished/1000
            Log.d("onTick","onTick")
            txtTimeLeft.text=getString(R.string.time_left,timeLeft.toString())
                }override fun onFinish(){
                    endGame()
                    Log.d("EndGame","endgame")
        }
        }
    }
    private fun endGame(){
        startMusic?.stop()
        startMusic?.release()

        startMusic?.start()
        Toast.makeText(this,getString(R.string.end_game)+score,Toast.LENGTH_LONG)
            .show()
        button1.isEnabled=false
    }
}