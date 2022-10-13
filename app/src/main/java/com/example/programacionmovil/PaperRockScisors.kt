package com.example.programacionmovil

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import kotlin.math.log

class PaperRockScisors : AppCompatActivity() {
    private var mSensorManager: SensorManager?=null
    private var mSensorListener:ShakeEventListener? =null
    internal lateinit var animationRockScisors: LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper_rock_scisors)
        mSensorListener= ShakeEventListener()
        mSensorManager =getSystemService(Context.SENSOR_SERVICE)as SensorManager?

        val btnjugar: Button = findViewById(R.id.play)
        val imgwait: ImageView = findViewById(R.id.imageWait)
        var randomSelect=0
        this.mSensorListener!!.setOnShakeListener(){
            randomSelect =(1..3).random()
            Log.d("randomNumber", randomSelect.toString());
            imgwait.setImageResource(R.drawable.papel)
            imgwait.setImageResource(R.drawable.roca)
            imgwait.setImageResource(R.drawable.tijera)
            when (randomSelect){
                1->  imgwait.setImageResource(R.drawable.papel)
                2->  imgwait.setImageResource(R.drawable.roca)
                3->  imgwait.setImageResource(R.drawable.tijera)
            }
        }
        btnjugar.setOnClickListener() {
            var rnd = (1..3).random()
            Log.d("randomNumber", rnd.toString());

            when (rnd) {
                1 -> imgwait.setImageResource(R.drawable.papel)
                2 -> imgwait.setImageResource(R.drawable.roca)
                3 -> imgwait.setImageResource(R.drawable.tijera)
            }
        }

    }
    override fun onResume(){
        super.onResume()
        mSensorManager!!.registerListener(
            mSensorListener,
            mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_UI
        )
    }
    override fun onPause(){
        mSensorManager!!.unregisterListener(mSensorListener)
        super.onPause()
    }
}